package com.javalab.stream;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

/**
 * @author Tham
 */
public class LocalDateStream {
    public static void main(String[] args) {
        LocalDateStream localDateStream = new LocalDateStream();
        localDateStream.doLocalDateStream();
    }

    private void doLocalDateStream() {
        LocalDate now = LocalDate.now();
        List<LocalDate> list = now.datesUntil(LocalDate.of(2024, 12, 31))
                .toList();
        System.out.println(list);
    }
}
