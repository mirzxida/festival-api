package com.example.festival.utils;

public class ReflectionUtils {
    public static void inspect(Object obj) {
        Class<?> c = obj.getClass();

        System.out.println("Class: " + c.getName());

        for (var f : c.getDeclaredFields())
            System.out.println("Field: " + f.getName());

        for (var m : c.getDeclaredMethods())
            System.out.println("Method: " + m.getName());
    }
}
