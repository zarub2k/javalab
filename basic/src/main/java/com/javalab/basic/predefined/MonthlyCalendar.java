package com.javalab.basic.predefined;

import java.time.LocalDate;

/**
 * @author Tham
 */
public class MonthlyCalendar {
    public static void main(String[] args) {
        new MonthlyCalendar().printMonthly();
    }

    private void printMonthly() {
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();

        int today = date.getDayOfMonth();
        date = date.minusDays(today - 1);
        int dayOfWeek = date.getDayOfWeek().getValue();
        System.out.println(dayOfWeek);

        System.out.println("Mon\tTue\tWed\tThu\tFri\tSat\tSun");

        for (int i = 1; i < dayOfWeek; i++) {
            System.out.print("\t");
        }

        while (date.getMonthValue() == month) {
            System.out.printf("%4d", date.getDayOfMonth());

            if (date.getDayOfMonth() == today) {
                System.out.print("*");
            }

            date = date.plusDays(1);
            if (date.getDayOfWeek().getValue() == 1) {
                System.out.println();
            }
        }
    }
}
