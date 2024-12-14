package com.javalab.stream;

import com.javalab.model.Book;
import com.javalab.model.BooksGenerator;
import com.javalab.model.Genre;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Tham
 */
public class SimpleStream {
    public static void main(String[] args) {
        SimpleStream simpleStream = new SimpleStream();
//        simpleStream.doRegularList();

        simpleStream.doStream();
    }

    private void doStream() {
        List<Book> filteredBooks = BooksGenerator
                .books()
                .stream()
                .filter(book -> book.year() < 2002)
                .filter(book -> book.genre() == Genre.FICTION)
//                .map(Book::title)
                .sorted(Comparator.comparing(Book::title))
                .limit(3L)
                .toList();

        System.out.println("*** doStream() ***");
        System.out.println(filteredBooks);
    }

    //Filter books published before 2005 + Sort by title
    private void doRegularList() {
        List<Book> books = BooksGenerator.books();
        books.sort(Comparator.comparing(Book::title));

        List<Book> filteredList = new ArrayList<>(4);

        for (Book book: books) {
            if (book.year() > 2005) {
                continue;
            }

            filteredList.add(book);
            if (filteredList.size() == 3) {
                break;
            }
        }

        System.out.println("*** doRegularList() ***");
        System.out.println(filteredList);
    }
}
