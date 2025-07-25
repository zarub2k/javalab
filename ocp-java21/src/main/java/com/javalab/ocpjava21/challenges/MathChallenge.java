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
        MathChallenge.extractDigits(2710);
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
