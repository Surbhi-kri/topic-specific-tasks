package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class FunctionMap<T, R> {
    private final Map<String, Function<T, R>> functionMap;

    public FunctionMap() {

        functionMap = new HashMap<>();
    }

    public void addFunction(String name, Function<T, R> function) {

        functionMap.put(name, function);
    }

    public Function<T, R> getFunction(String name) {
            return functionMap.get(name);

    }
    public static void main(String[] args) {
        // Get the integer function map
        FunctionMap<Integer, Integer> intFuncs = Functions.intFunctionMap();

        // Test abs function
        Function<Integer, Integer> absFunc = intFuncs.getFunction("abs");
        System.out.println("abs(-10) = " + absFunc.apply(-10));

        // Test sign function
        Function<Integer, Integer> signFunc = intFuncs.getFunction("sgn");
        System.out.println("sgn(-10) = " + signFunc.apply(-10));
        System.out.println("sgn(0) = " + signFunc.apply(0));
        System.out.println("sgn(5) = " + signFunc.apply(5));

        // Test increment
        Function<Integer, Integer> incFunc = intFuncs.getFunction("increment");
        System.out.println("increment(5) = " + incFunc.apply(5));

        // Test decrement
        Function<Integer, Integer> decFunc = intFuncs.getFunction("decrement");
        System.out.println("decrement(5) = " + decFunc.apply(5));

        // Test square
        Function<Integer, Integer> squareFunc = intFuncs.getFunction("square");
        System.out.println("square(5) = " + squareFunc.apply(5));
    }
}
