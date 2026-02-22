package org.example;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(1,2,3,4,5,6);

        System.out.println("Even numbers:");
        FilterEven.printEven(numbers);

        System.out.println("Squares:");
        SquareAll.printSquares(numbers);

        System.out.println("Sum:");
        System.out.println(SumAll.sum(numbers));
    }
}