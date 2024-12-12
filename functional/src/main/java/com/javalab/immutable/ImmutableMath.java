package com.javalab.immutable;

import java.math.BigDecimal;

/**
 * @author tham
 */
public class ImmutableMath {
    public static void main(String[] args) {
        new ImmutableMath().doBigDecimal();
    }

    private void doBigDecimal() {
        BigDecimal initial = new BigDecimal(50);

        BigDecimal after = initial.add(BigDecimal.TEN);

        System.out.println("After added: " + initial);
        System.out.println("Result: " + after);
    }
}
