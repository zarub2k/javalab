package com.javalab.grounded;

/**
 *
 * @author Tham
 */
public class SwitchExpression {
    public static void main(String[] args) {
        SwitchExpression instance = new SwitchExpression();
        String season = instance.switchExprWithArrowValue("Anything");
        System.out.println("Season: " + season);
    }
    
    private String switchExprWithArrowValue(String month) {
        String season = switch (month) {
            case "Dec", "Jan", "Feb" -> "Winter";
            case "Mar", "Apr", "May" -> "Summer";
            case "Jun", "Jul", "Aug", "Sep" -> "Monsoon";
            case "Oct", "Nov" -> "Autumn";
            default -> "No season";
        };

        return season;
    }
    
    private void switchExprWithArrow(String month) {
        switch(month) {
            case "Dec", "Jan", "Feb" ->
                System.out.println("Winter");
            case "Mar", "Apr", "May" ->
                System.out.println("Summer");
            case "Jun", "Jul", "Aug", "Sep" ->
                System.out.println("Monsoon");
            case "Oct", "Nov" -> 
                System.out.println("Autumn");
        };
    }
    
    private void simpleSwitch(String month) {
        switch (month) {
            case "Dec":
            case "Jan":
            case "Feb":
                System.out.println("Winter season");
                break;
            case "Mar":
            case "Apr":
            case "May":
                System.out.println("Summer season");
                break;
            case "Jun":
            case "Jul":
            case "Aug":
            case "Sep":
                System.out.println("Monsoon season");
                break;
            case "Oct":
            case "Nov":
                System.out.println("Autumn (Post-Monsoon) season");
                break;
        }
    }

    private String switchWithValue(String month) {
        String season = null;

        switch (month) {
            case "Dec":
            case "Jan":
            case "Feb":
                season = "Winter";
                break;
            case "Mar":
            case "Apr":
            case "May":
                season = "Summer";
            case "Jun":
            case "Jul":
            case "Aug":
            case "Sep":
                season = "Monsoon";
                break;
            case "Oct":
            case "Nov":
                season = "Autumn";
                break;
        }

        System.out.println("Season: " + season);
        return season;
    }
    
    private String switchExprWithYield(String month) {
        return switch (month) {
            case "Dec", "Jan", "Feb":
                yield "Winter";
            case "Mar", "Apr", "May":
                yield "Summer";
            case "Jun", "Jul", "Aug", "Sep":
                yield "Monsoon";
            case "Oct", "Nov":
                yield "Autumn";
            default:
                yield "Not a season";
        };
    }
    
    private enum Shape {
        CIRCLE, SQUARE, RECTANGLE, TRIANGLE
    }
    
    private void findShape(Shape shape) {
        switch (shape) {
            case CIRCLE:
                System.out.println("This is a circle");
                break;
            case SQUARE:
                System.out.println("This is a square");
                break;
            case RECTANGLE:
                System.out.println("This is a rectangle");
                break;
            case TRIANGLE:
                System.out.println("This is a triangle");
                break;
        }
    }
}
