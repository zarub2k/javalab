package com.javalab.ds;

import java.util.BitSet;

/**
 * @author Tham
 */
public class BitSetPerformance {
    public static void main(String[] args) {
        BitSetPerformance bitSetPerformance = new BitSetPerformance();
        bitSetPerformance.doSimpleBitSet();
    }

    private void doSimpleBitSet() {
        BitSet bitSet = new BitSet(2);
        System.out.println(bitSet);
        bitSet.set(0, bitSet.size() / 4, true);
        System.out.println(bitSet);

        bitSet.clear(0);
        System.out.println(bitSet);
    }
}
