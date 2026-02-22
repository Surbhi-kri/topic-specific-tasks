package org.example;

public class Main {

    public static void main(String[] args) {

        String email = "surbhi@gmail.com";

        boolean valid = RegexUtils.isValidEmail(email);

        System.out.println("Is email valid? " + valid);
    }
}