package org.example;

public class Main {

    public static void main(String[] args) {

        // Test Box
        Box<String> box = new Box<>();
        box.setContent("Hello Surbhi");
        System.out.println(box.getContent());
        // Test NumericBox
        NumericBox<Integer> num = new NumericBox<>(100);
        System.out.println("NumericBox value: " + num.getValue());
        System.out.println("NumericBox double value: " + num.doubleValue());

        // Test Utils swap
        Integer[] arr = {1, 2, 3};
        Utils.swap(arr, 0, 2);

        System.out.println("After swap:");
        for (int i : arr) {
            System.out.println(i);
        }

        Utils.printMessage("Generics working successfully!");
    }
}