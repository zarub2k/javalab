package com.javalab.jdk25;

import module java.base;
import java.sql.Date;

//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;

//import java.util.*;

/**
 *
 * @author Tham
 */
public class ImportModuleExample {
    public static void main(String[] args) {        
        List<Integer> numbers = List.of(1, 2, 3);
        
        int index = 0;
        Map numberMap = new HashMap();
        for (Integer number : numbers) {
            numberMap.put(index, number);
            index++;
        }
        
        Date baseDate = new Date(System.currentTimeMillis());
        Date sqlDate = new Date(System.currentTimeMillis());
    }
}
