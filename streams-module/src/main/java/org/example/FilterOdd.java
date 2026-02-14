package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class FilterOdd {
    public static List<Integer> filter(List<Integer> numbers) {
        return numbers.stream().filter(n -> n % 2 != 0).collect(Collectors.toList());
    }
}
