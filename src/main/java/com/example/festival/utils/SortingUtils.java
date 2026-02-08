package com.example.festival.utils;

import java.util.Comparator;
import java.util.List;

public class SortingUtils {
    public static <T> List<T> sort(
            List<T> list,
            Comparator<T> comparator) {

        return list.stream()
                .sorted(comparator)
                .toList();
    }
}
