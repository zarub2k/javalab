package com.javalab.general;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class SystemExample {
    public static void main(String[] args) {
        Properties properties = System.getProperties();
        properties.forEach((key, value) -> System.out.println(key + " > " + value));

//        for (Map.Entry<Object, Object> entry: properties.entrySet()) {
//            System.out.println(entry.getKey() + " > " + entry.getValue());
//        }
    }
}
