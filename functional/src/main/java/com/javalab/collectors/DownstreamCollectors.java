package com.javalab.collectors;

import com.javalab.model.*;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Tham
 */
public class DownstreamCollectors {
    public static void main(String[] args) {
        DownstreamCollectors downstreamCollectors = new DownstreamCollectors();
//        downstreamCollectors.doTransforming();
//        downstreamCollectors.doMultiple();
//        downstreamCollectors.doReducing();
//        downstreamCollectors.doFlattening();
        downstreamCollectors.doFiltering();
    }

    //Grouping elements into a simple key-value pair map
    private void doTransforming() {
        List<Book> books = DataGenerator.books();
        Map<Genre, List<Book>> booksByGenre = books.stream()
                .collect(Collectors.groupingBy(Book::genre));
        System.out.println(booksByGenre);
    }

    private void doReducing() {
        var summingUp = Collectors.reducing(0, Integer::sum);
        var downStream = Collectors.mapping((Book book) -> book.year(), summingUp);

        Map<Integer, Integer> collect = DataGenerator.books()
                .stream()
                .collect(Collectors.groupingBy(Book::year, downStream));
        System.out.println(collect);

        //Another way
        var downStream1 = Collectors.reducing(0,
                (Book book) -> book.year(),
                Integer::sum);
        Map<Integer, Integer> reduceResult = DataGenerator.books()
                .stream()
                .collect(Collectors.groupingBy(Book::year, downStream1));
        System.out.println(reduceResult);

        //3rd way
        var downStream2 = Collectors.summingInt((Book book) -> book.year());
        Map<Integer, Integer> reduceResult1 = DataGenerator.books()
                .stream()
                .collect(Collectors.groupingBy(Book::year, downStream2));
        System.out.println(reduceResult1);
    }

    private void doFlattening() {
        var downstream = Collectors.flatMapping((Organization org) -> org.users().stream(), Collectors.toList());

        Map<String, List<User>> result = DataGenerator.orgs("ORG", 3)
                .stream()
                .collect(Collectors.groupingBy(Organization::city, downstream));
        System.out.println(result);
    }

    private void doFiltering() {
        //Filter and then group TYPE - 1
        Predicate<User> ageBelow50 = Predicate.not(user -> user.age() > 25);

        //>>> with intermediate filter
        List<User> users = DataGenerator.users("USR", 10);
        System.out.println(users);
        Map<Integer, Set<String>> resultFilterThenGroup = users
                .stream()
                .filter(ageBelow50)
                .collect(Collectors.groupingBy(User::age,
                        Collectors.mapping(User::name, Collectors.toSet())));
        System.out.println(resultFilterThenGroup);

        //Group and then filter TYPE - 2
        Map<Integer, Set<String>> resultGroupThenFilter = users.stream()
                .collect(Collectors.groupingBy(User::age,
                        Collectors.filtering(ageBelow50, Collectors.mapping(User::name, Collectors.toSet()))));
        System.out.println(resultGroupThenFilter);
    }

    /*private void doMultiple() {
        //Collect elements to toSet
        Collector<Book, ?, Set<Book>> collectToSet = Collectors.toSet();

        //Map from book to title
        Collector<Book, ?, Set<String>> mapToTitle = mapping(Book::title, collectToSet);

        //Grouping by genre
        Collector<Book, ?, Map<Genre, Set<String>>> groupingByGenre = Collectors.groupingBy(Book::genre, mapToTitle);

        Map<String, Set<String>> lookup = BooksGenerator.books()
                .stream()
                .collect(groupingByGenre(Book::genre, mapping(Book::title, collectToSet)));

        System.out.println(lookup);
    }*/
}
