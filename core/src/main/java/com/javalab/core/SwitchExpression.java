package com.javalab.core;

/**
 * @author tham
 */
public class SwitchExpression {
    public String getSeason(int month) {
        return switch(month) {
            case 1, 2, 3 -> "Q1";
            case 4, 5, 6 -> "Q2";
            case 7, 8, 9 -> "Q3";
            case 10, 11, 12 -> "Q4";
            default -> {
                throw new RuntimeException("Invalid month");
            }
        };
    }

    public static void main(String[] args) {
        String season = new SwitchExpression().getSeason(4);
        System.out.println(season);
    }
}
