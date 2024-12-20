package com.javalab.loops;

import com.javalab.model.Book;
import com.javalab.model.DataGenerator;
import com.javalab.util.StopWatch;

import java.util.List;

/**
 * @author Tham
 */
public class ForOptimization {
    public static void main(String[] args) {
        ForOptimization forOptimization = new ForOptimization();
        forOptimization.doNormal();
        forOptimization.doOptimize();
    }

    private void doNormal() {
        List<Book> books = DataGenerator.books();
        int count = 0;

        StopWatch stopWatch = StopWatch.start();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).title().contains("e")) {
                count++;
            }
        }

        System.out.println("Time taken for doNormal(): " + stopWatch.time());
        System.out.println("Number of books matched: " + count);
    }

    private void doOptimize() {
        List<Book> books = DataGenerator.books();
        int count = 0;

        int size = books.size();
        StopWatch stopWatch = StopWatch.start();
        for (int i = 0; i < size; i++) {
            String title = books.get(i).title();
            if (title.indexOf('e') != -1) {
                count++;
            }
        }

        System.out.println("Time taken for doOptimize(): " + stopWatch.time());
        System.out.println("Number of books matched... " + count);
    }
}
