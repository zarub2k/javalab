package com.javalab.basic.controlflow;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Tham
 */
public class MultiArray {
    final double STARTRATE = 5;
    final int NRATES = 6;
    final int NYEARS = 10;

    public static void main(String[] args) {
        MultiArray multiArray = new MultiArray();
        multiArray.compoundInterest();
    }

    private void compoundInterest() {
        double[] intRates = new double[NRATES];
        for (int i = 0; i < intRates.length; i++) {
            intRates[i] = (STARTRATE + i) / 100.0;
        }
        System.out.println(Arrays.toString(intRates));

        double[][] balances = new double[NYEARS][NRATES];

        //set initial balances
        Arrays.fill(balances[0], 10000);

        //compute future interests
        for (int i = 1; i < balances.length; i++) {
            for (int j = 0; j < balances[i].length; j++) {

                //previous balance
                double oldBalance = balances[i - 1][j];

                //compute interest
                double interest = oldBalance * intRates[j];

                //compute this year balance
                balances[i][j] = oldBalance + interest;
            }
        }

        printMultiArray(intRates, balances);

//        System.out.println(Arrays.deepToString(balances));
    }

    private void printMultiArray(double[] titles, double[][] values) {
        for (double title : titles) {
            System.out.printf("%9.0f%%", 100 * title);
        }
        System.out.println();

        for (double[] row: values) {
            for (double value: row) {
                System.out.printf("%10.2f", value);
            }
            System.out.println();
        }
    }
}
