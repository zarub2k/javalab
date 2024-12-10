package com.javalab.core.clazz;

import java.net.http.HttpClient;

public class ClazzLoader {
    public static void main(String[] args) {
        System.out.println(Object.class.getClassLoader());
        System.out.println(HttpClient.class.getClassLoader());
        System.out.println(ClazzLoader.class.getClassLoader());
    }
}
