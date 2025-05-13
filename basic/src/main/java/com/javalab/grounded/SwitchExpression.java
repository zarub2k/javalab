package com.javalab.grounded;

/**
 *
 * @author Tham
 */
public class SwitchExpression {
    public static void main(String[] args) {
        SwitchExpression instance = new SwitchExpression();
        instance.switchOld("Feb");
        
        String swithWithReturn = instance.swithWithReturn("Feb");
        System.out.println(swithWithReturn);
    }
    
//    private static final List<String> months = List.of(
//        "Jan", "Feb", "Mar", "Apr", "May", "Jun", 
//        "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
//    );
    
    private void switchOld(String month) {
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
    
    private String swithWithReturn(String month) {
        String season = null;
        
        switch (month) {
            case "Dec":
            case "Jan":
            case "Feb":
                System.out.println("Winter season");
                season = "Winter";
                break;
            case "Mar":
            case "Apr":
            case "May":
                System.out.println("Summer season");
                season = "Summer";
                break;
            case "Jun":
            case "Jul":
            case "Aug":
            case "Sep":
                System.out.println("Monsoon season");
                season = "Monsoon";
                break;
            case "Oct":
            case "Nov":
                System.out.println("Autumn (Post-Monsoon) season");
                season = "Autumn";
                break;
        }
        
        return season;
    }
    
    private void switchWithArrow(String month) {
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
    
    private String switchExprWithArrow(String month) {
        String season = switch (month) {
            case "Dec", "Jan", "Feb" -> "Winter";
            case "Mar", "Apr", "May" -> "Summer";
            case "Jun", "Jul", "Aug", "Sep" -> "Monsoon";
            case "Oct", "Nov" -> "Autumn";
            default -> "No season";
        };
        
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
}
