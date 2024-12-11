package com.javalab.functional;

import java.util.function.Function;

/**
 * @author tham
 */
public class FunctionalComposition {
    public static void main(String[] args) {

        Function<String, String> removeFn = str -> str.replace("a", "");
        Function<String, String> upperFn = String::toUpperCase;

        String input = "Thamizharasu";

        //andThen way -> andThen(after)
        String andThenOutput = removeFn
                .andThen(upperFn)
                .apply(input);
        System.out.println("andThen way: " + andThenOutput);

        //compose way -> compose(before)
        String composeOutput1 = removeFn
                .compose(upperFn)
                .apply(input);
        System.out.println("compose1 way: " + composeOutput1);

        String composeOutput2 = upperFn
                .compose(removeFn)
                .apply(input);
        System.out.println("compose2 way: " + composeOutput2);
    }
}
