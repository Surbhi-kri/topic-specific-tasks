package org.example;

import java.util.List;

public class SumAll {
    public static int sum(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
