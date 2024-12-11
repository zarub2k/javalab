package com.javalab.functional;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author tham
 */
public class FourTypesFunctionalInterfaces {
    public static void main(String[] args) {
        FourTypesFunctionalInterfaces fourTypesFunctionalInterfaces = new FourTypesFunctionalInterfaces();

        //Function
        fourTypesFunctionalInterfaces.doFunction();

        //Consumer
        fourTypesFunctionalInterfaces.doConsumer();

        //Supplier
        fourTypesFunctionalInterfaces.doSupplier();

        //Predicate
        fourTypesFunctionalInterfaces.doPredicate();
    }

    //Accepts an input and gives an output either true or false
    private void doPredicate() {
        Predicate<Integer> over100 = i -> i > 100;
        System.out.println("125 is greater than 100: " + over100.test(125));
        System.out.println("99 is greater than 100: " + over100.test(99));
    }

    //No input but produces an output
    private void doSupplier() {
        Supplier<Double> random = () -> Math.random();
        System.out.println(random.get());
        System.out.println(random.get());
    }

    //Consumes inputs and no output
    private void doConsumer() {
        Consumer<String> consumer = str -> System.out.println(str);
        consumer.accept("Hello Thamizharasu");
    }

    //Applies input and output
    private void doFunction() {
        Function<String, Integer> fn = str -> str != null ? str.length() : 0;
        System.out.println(fn.apply("Tham"));
        System.out.println(fn.apply("Hello Tham"));
    }
}
