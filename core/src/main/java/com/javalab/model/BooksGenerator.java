package com.javalab.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tham
 */
public class BooksGenerator {
    public static List<Book> books() {
        List<Book> temp = List.of(
                new Book("One", 2000, Genre.NOVEL),
                new Book("AAA", 1989, Genre.FICTION),
                new Book("Two", 1700, Genre.FICTION),
                new Book("Three", 2005, Genre.MYSTRY),
                new Book("Four", 2000, Genre.FICTION),
                new Book("Five", 1999, Genre.SCIENCE_FICTION),
                new Book("Six", 1989, Genre.FICTION),
                new Book("Seven", 2006, Genre.THRILLER)
        );

        List<Book> books = new ArrayList<>(temp.size());
        books.addAll(temp);

        return books;
    }
}
