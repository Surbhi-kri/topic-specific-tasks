package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class SquareAll {
    public static List<Integer> square(List<Integer> numbers) {
        return numbers.stream().map(n -> n * n).collect(Collectors.toList());
    }
}