package org.example;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.function.*;
import java.util.Comparator;

public class CrazyLambdas {

    public static Supplier<String> helloSupplier() {
        return () -> "Hello";
    }

    public static Predicate<String> isEmptyPredicate() {
        return String::isEmpty;
    }

    public static BiFunction<String, Integer, String> stringMultiplier() {
        return (s, n) -> s.repeat(n);
    }

    public static Function<BigDecimal, String> toDollarStringFunction() {
        return bd -> "$" + bd.toString();
    }

    public static Predicate<String> lengthInRangePredicate(int min, int max) {
        return s -> s.length() >= min && s.length() < max;
    }

    public static IntSupplier randomIntSupplier() {
        return () -> (int) (Math.random() * Integer.MAX_VALUE);
    }

    public static IntUnaryOperator boundedRandomIntSupplier() {
        return bound -> (int) (Math.random() * bound);
    }

    public static IntUnaryOperator intSquareOperation() {
        return x -> x * x;
    }

    public static LongBinaryOperator longSumOperation() {
        return (a, b) -> a + b;
    }

    public static ToIntFunction<String> stringToIntConverter() {
        return Integer::parseInt;
    }

    public static Supplier<IntUnaryOperator> nMultiplyFunctionSupplier(int n) {
        return () -> x -> n * x;
    }

    public static UnaryOperator<Function<String, String>> composeWithTrimFunction() {
        return f -> f.andThen(String::trim);
    }

    public static Supplier<Thread> runningThreadSupplier(Runnable runnable) {
        return () -> {
            Thread t = new Thread(runnable);
            t.start();
            return t;
        };
    }

    public static Consumer<Runnable> newThreadRunnableConsumer() {
        return r -> new Thread(r).start();
    }

    public static Function<Runnable, Supplier<Thread>> runnableToThreadSupplierFunction() {
        return r -> () -> {
            Thread t = new Thread(r);
            t.start();
            return t;
        };
    }

    public static BiFunction<IntUnaryOperator, IntPredicate, IntUnaryOperator> functionToConditionalFunction() {
        return (func, pred) -> x -> pred.test(x) ? func.applyAsInt(x) : x;
    }

    public static BiFunction<Map<String, IntUnaryOperator>, String, IntUnaryOperator> functionLoader() {
        return (map, name) -> map.getOrDefault(name, IntUnaryOperator.identity());
    }

    public static <T, U extends Comparable<? super U>> Comparator<T> comparing(Function<? super T, ? extends U> mapper) {
        return (a, b) -> mapper.apply(a).compareTo(mapper.apply(b));
    }

    public static <T, U extends Comparable<? super U>> Comparator<T> thenComparing(
            Comparator<? super T> comparator, Function<? super T, ? extends U> mapper) {
        return (a, b) -> {
            int res = comparator.compare(a, b);
            return res != 0 ? res : mapper.apply(a).compareTo(mapper.apply(b));
        };
    }

    public static Supplier<Supplier<Supplier<String>>> trickyWellDoneSupplier() {
        return () -> () -> () -> "WELL DONE!";
    }

    public static void main(String[] args) {

        // Supplier example
        Supplier<String> hello = CrazyLambdas.helloSupplier();
        System.out.println("Hello Supplier: " + hello.get());

        // Predicate example
        Predicate<String> emptyCheck = CrazyLambdas.isEmptyPredicate();
        System.out.println("Is empty? " + emptyCheck.test("")); // true
        System.out.println("Is empty? " + emptyCheck.test("abc")); // false

        // BiFunction example
        BiFunction<String, Integer, String> repeat = CrazyLambdas.stringMultiplier();
        System.out.println("String multiply: " + repeat.apply("Hi", 3));

        // Function example
        Function<BigDecimal, String> dollarString = CrazyLambdas.toDollarStringFunction();
        System.out.println("Dollar String: " + dollarString.apply(new BigDecimal("123.45")));

        // Predicate with range
        Predicate<String> lengthCheck = CrazyLambdas.lengthInRangePredicate(2, 5);
        System.out.println("Length in range? " + lengthCheck.test("Hey")); // true

        // IntSupplier example
        IntSupplier randomInt = CrazyLambdas.randomIntSupplier();
        System.out.println("Random int: " + randomInt.getAsInt());

        // IntUnaryOperator example
        IntUnaryOperator square = CrazyLambdas.intSquareOperation();
        System.out.println("Square of 5: " + square.applyAsInt(5));

        // LongBinaryOperator example
        LongBinaryOperator sum = CrazyLambdas.longSumOperation();
        System.out.println("Sum of 10 and 20: " + sum.applyAsLong(10, 20));

        // ToIntFunction example
        ToIntFunction<String> toInt = CrazyLambdas.stringToIntConverter();
        System.out.println("String to int: " + toInt.applyAsInt("123"));

        // Supplier of function example
        Supplier<IntUnaryOperator> multiplyBy3 = CrazyLambdas.nMultiplyFunctionSupplier(3);
        System.out.println("3*5 = " + multiplyBy3.get().applyAsInt(5));

        // UnaryOperator example (compose function)
        UnaryOperator<Function<String, String>> trimFunc = CrazyLambdas.composeWithTrimFunction();
        Function<String, String> f = s -> s.toUpperCase();
        System.out.println("Trim & upper: " + trimFunc.apply(f).apply("  hello  "));

        // Running thread supplier
        Runnable task = () -> System.out.println("Thread running!");
        Supplier<Thread> threadSupplier = CrazyLambdas.runningThreadSupplier(task);
        threadSupplier.get();

        // Consumer example (start thread)
        Consumer<Runnable> startThread = CrazyLambdas.newThreadRunnableConsumer();
        startThread.accept(() -> System.out.println("Thread via consumer!"));

        // Function to supplier example
        Function<Runnable, Supplier<Thread>> rToThread = CrazyLambdas.runnableToThreadSupplierFunction();
        rToThread.apply(() -> System.out.println("Runnable to thread!")).get();

        // Conditional function example
        BiFunction<IntUnaryOperator, IntPredicate, IntUnaryOperator> conditional =
                CrazyLambdas.functionToConditionalFunction();
        IntUnaryOperator doubleIfEven = conditional.apply(x -> x * 2, x -> x % 2 == 0);
        System.out.println("Double 4? " + doubleIfEven.applyAsInt(4)); // 8
        System.out.println("Double 5? " + doubleIfEven.applyAsInt(5)); // 5

        // Function loader example
        Map<String, IntUnaryOperator> map = new HashMap<>();
        map.put("square", x -> x * x);
        BiFunction<Map<String, IntUnaryOperator>, String, IntUnaryOperator> loader =
                CrazyLambdas.functionLoader();
        System.out.println("Loaded square: " + loader.apply(map, "square").applyAsInt(5));

        // Comparator example
        Comparator<String> comp = CrazyLambdas.comparing(String::length);
        System.out.println("Compare 'hi' vs 'hello': " + comp.compare("hi", "hello")); // -1

        // ThenComparing example
        Comparator<String> thenComp = CrazyLambdas.thenComparing(comp, String::toUpperCase);
        System.out.println("Then compare 'hi' vs 'HI': " + thenComp.compare("hi", "HI")); // 0

        // Nested Supplier example
        Supplier<Supplier<Supplier<String>>> wellDone = CrazyLambdas.trickyWellDoneSupplier();
        System.out.println("Nested Supplier: " + wellDone.get().get().get());
    }
}
