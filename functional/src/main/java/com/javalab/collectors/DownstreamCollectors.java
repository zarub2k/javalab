package com.javalab.collectors;

import com.javalab.model.Book;
import com.javalab.model.BooksGenerator;
import com.javalab.model.Genre;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author Tham
 */
public class DownstreamCollectors {
    public static void main(String[] args) {
        DownstreamCollectors downstreamCollectors = new DownstreamCollectors();
        downstreamCollectors.doTransforming();
    }

    //Grouping elements into a simple key-value pair map
    private void doTransforming() {
        List<Book> books = BooksGenerator.books();
        Map<Genre, List<Book>> booksByGenre = books.stream()
                .collect(Collectors.groupingBy(Book::genre));
        System.out.println(booksByGenre);
    }

    private void doMultiple() {
        //Collect elements to toSet
        Collector<Book, ?, Set<Book>> collectToSet = Collectors.toSet();

        //Map from book to title
        Collector<Book, ?, Set<String>> mapToTitle = Collectors.mapping(Book::title, collectToSet);

        //Grouping by genre
        Collector<Book, ?, Map<Genre, Set<String>>> groupingByGenre = Collectors.groupingBy(Book::genre, mapToTitle);

        BooksGenerator.books()
                .stream()
                .collect(groupingByGenre(Book::genre, mapToTitle(Book::title, collectToSet)));
    }
}
