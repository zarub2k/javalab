package com.javalab.ocpjava21.challenges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Tham
 */
public class MathChallenge {
    public static void main(String[] args) {
        MathChallenge.findAllPrimes(40);
    }
    
    /**
     * 
     * @param value 
     */
    public static void findAllPrimes(int value) {
        List primeNumebers = new ArrayList();
        
        for (int i = 2; i < value; i++) {
            if (isPrime(i)) {
                primeNumebers.add(i);
            }
        }
        
        System.out.println("Prime numbers: \n" + primeNumebers);
    }
    
    private static boolean isPrime(int index) {
        for (int i = 2; i <= index / 2; i++) {
            if (index % i == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Find the divisors of a given integer value
     * 
     * @param value 
     */
    public static void findDivisors(int value) {
        //Validate if the input is zero or negative number
        if (value <= 0) {
            System.out.println("Provide a value which is greater than 0");
            return;
        }
        
        final List<Integer> divisors = new ArrayList();
        for (int i = 1; i <= value / 2; i++) {
            if (value % i == 0) {
                divisors.add(i);
            }
        }
        
        //If needed add the same number itself
        divisors.add(value);
        
        System.out.println("Divisors are: \n" + divisors);
    }
    
    public static void extractDigits(int value) {
        List<Integer> finalNumbers = new ArrayList();

        int remaining = value;
        while (remaining > 0) {
            int digit = remaining % 10;
            
            finalNumbers.add(digit);
            remaining = remaining / 10;
        }
        
        Collections.reverse(finalNumbers);
        System.out.println(finalNumbers);
    }
}
