package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class FilterContains {
    public static List<String> filter(List<String> strings, String sub) {
        return strings.stream().filter(s -> s.contains(sub)).collect(Collectors.toList());
    }
}
