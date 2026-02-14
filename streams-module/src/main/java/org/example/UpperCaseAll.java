package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class UpperCaseAll {
    public static List<String> convert(List<String> strings) {
        return strings.stream().map(String::toUpperCase).collect(Collectors.toList());
    }
}
