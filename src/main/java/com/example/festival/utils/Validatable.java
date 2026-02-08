package com.example.festival.utils;

public interface Validatable<T> {
    void validate(T obj);
    default boolean isNull(T obj) {
        return obj == null;
    }
    static void require(boolean condition, String msg) {
        if (!condition) throw new IllegalArgumentException(msg);
    }
}
