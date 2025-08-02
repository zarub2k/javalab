package com.javalab.ocpjava21.challenges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Tham
 */
public class MathChallenge {
    public static void main(String[] args) {
        MathChallenge.findArmstrongNumbers(999);
    }
    
    /**
     * 153 = 1*100 + 5*10 + 3 = 1^3 + 5^3 + 3^3
     * 
     * Output for range 999 > [153, 370, 371, 407]
     * @param range 
     */
    public static void findArmstrongNumbers(int range) {
        if (range < 100 || range > 999) {
            System.out.println("The given range is NOT applicable");
        }
        
        List armstrongNumbers = new ArrayList();
        for (int i = 100; i <= range; i++) {
            int sum = 0;
            for (int digit: extractDigits(i)) {
                sum += Math.pow(digit, 3);
            }
            
            if (sum == i) {
                armstrongNumbers.add(i);
            }
        }
        
        System.out.println("Amstrong numbers: \n" + armstrongNumbers);
    }
    
    
    /**
     * Twins -> If the boundary between two primes are 2
     * Cousin -> If the boundary between two primes are 4
     * Sexy -> If the boundary between two primes are 6
     * 
     * @param boudary
     * @param distance 
     */
    public static void findAllPrimePairs(int boudary, int distance) {
        Map<Integer, Integer> connectedPrimes = new LinkedHashMap<Integer, Integer>();
        for (int i = 2; i <= boudary; i++) {
            if (isPrime(i) && isPrime(i + distance)) {
                connectedPrimes.put(i, i + distance);
            }
        }
        
        String message = switch (distance) {
            case 2 -> "Prime twins are: \n" + connectedPrimes;
            case 4 -> "Prime cousins are: \n" + connectedPrimes;
            case 6 -> "Sexy primes are: \n" + connectedPrimes;
            default -> "No valid message";
        };
        
        System.out.println(message);
    }
    
    /**
     * Perfect numbers: 
     *   1. Find all the divisors of the given number
     *   2. Sum of all the divisors is equals to the original number
     * @param range 
     */
    public static void findPerfectNumbers(int range) {
        List perfectNumbers = new ArrayList();
        
        for (int i = 1; i <= range; i++) {
            if (isPerfect(i, getDivisors(i))) {
                perfectNumbers.add(i);
            }
        }
        
        System.out.println("Perfect numbers are: \n" + perfectNumbers);
    }
    
    private static boolean isPerfect(int original, List<Integer> divisors) {
        int sum = divisors.stream().mapToInt(Integer::intValue).sum();
        return (sum == original);
    }
    
    private static List getDivisors(int value) {
        final List<Integer> divisors = new ArrayList();
        for (int i = 1; i <= value / 2; i++) {
            if (value % i == 0) {
                divisors.add(i);
            }
        }

        return divisors;
    }
    
    /**
     * Find all the prime numbers for the given range value
     * Prime -> The number is divisible by 1 and the number itself
     * 1 is NOT a prime number
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
//        divisors.add(value);
        
        System.out.println("Divisors are: \n" + divisors);
    }
    
    public static List<Integer> extractDigits(int value) {
        List<Integer> finalNumbers = new ArrayList();

        int remaining = value;
        while (remaining > 0) {
            int digit = remaining % 10;
            
            finalNumbers.add(digit);
            remaining = remaining / 10;
        }
        
//        System.out.println(finalNumbers);
        Collections.reverse(finalNumbers);
        
        return finalNumbers;
    }
}
