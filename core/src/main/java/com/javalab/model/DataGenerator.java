package com.javalab.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Tham
 */
public class DataGenerator {
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

    public static List<User> users(String prefix, int count) {
        List<User> users = new ArrayList<>(count);
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            users.add(new User(prefix + i, random.nextInt()));
        }

        return users;
    }

    public static List<Organization> orgs(String prefix, int count) {
        List<Organization> orgs = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            orgs.add(new Organization(prefix + i, users(prefix + "USR", count)));
        }

        return orgs;
    }
}
