package com.javalab.ocpjava21.assessment;

/**
 * @author Tham
 *
 * Refer: <a href="https://learning.oreilly.com/library/view/ocp-oracle-certified/9781394286614/f08.xhtml#fintro-sec-0552">...</a>
 */
public class Assessment {
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
