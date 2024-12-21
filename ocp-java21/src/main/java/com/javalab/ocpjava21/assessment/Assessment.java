package com.javalab.ocpjava21.assessment;

import java.sql.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Tham
 *
 * Refer: <a href="https://learning.oreilly.com/library/view/ocp-oracle-certified/9781394286614/f08.xhtml#fintro-sec-0552">...</a>
 */
public class Assessment {

    /**
     *
     */
    public void do07() {
        int[] array = {6, 9, 8};
        System.out.println("Binary search: " + Arrays.binarySearch(array, 9));
        System.out.println("Array compare: " + Arrays.compare(array, new int[] {6, 9, 8}));
        System.out.println("Array mismatch: " + Arrays.mismatch(array, new int[] {6, 9, 8}));
    }


    /**
     * Result -> 15
     * No matter what the other method does, it will not change the value of a
     * Because the callee always sends the copy of the variable
     * The addToInt method can't change the value of a
     */
    public void do05() {
        var a = 15;
        var b = 10;
        Assessment.addToInt(a, b);
        System.out.println(a);
    }
    private static void addToInt(int a, int amountToAdd) {
        a = a + amountToAdd % -5;
    }

    /**
     * Result -> The code doesn't terminate
     * The filter will check for non-empty. Nothing will pass through the filter
     * So the code will never terminate
     */
    public void do04() {
        Predicate<String> empty = String::isEmpty;
        Predicate<String> nonEmpty = empty.negate();

        var result = Stream.generate(() -> "")
                .filter(nonEmpty)
                .collect(Collectors.groupingBy(k -> k))
                .entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .flatMap(Collection::stream)
                .collect(Collectors.partitioningBy(nonEmpty));
        System.out.println(result);
    }

    /**
     * validate the cross type assignment of int / float / double
     */
    public void do02() {
        int moon = 9, star = 2 + 2 * 3;
        float sun = star > 10 ? 1 : 3;
        double jupiter = (sun + moon) - 1.0f;
        int mars = --moon <= 8 ? 2 : 3;
        System.out.println(sun + ", " + jupiter + ", " + mars);
    }

    public void do01() {
        final int score1 = 8, score2 = 3;
        Integer myScore = 7;

        // *** The below code will not compile due to unreachable order of cases ***

        /*var goal = switch (myScore) {
            case score1, score2, 7 -> "Good";
            case Integer i when i < 10 -> "better";
            case Integer i when i >= 10 -> "best";
            default -> { yield "unknown";}
            case null -> "nope";
        };

        System.out.println(goal);*/
    }
}
