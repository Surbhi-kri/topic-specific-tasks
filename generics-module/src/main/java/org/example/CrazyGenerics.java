package org.example;

import lombok.Data;

import java.io.Serializable;
import java.util.*;

public class CrazyGenerics {

    @Data
    public static class Sourced<T> {
        private T value;
        private String source;

        public Sourced(T value, String source) {
            this.value = value;
            this.source = source;
        }
    }

    @Data
    public static class Limited<T extends Number> {
        private final T actual;
        private final T min;
        private final T max;

        public Limited(T actual, T min, T max) {
            this.actual = actual;
            this.min = min;
            this.max = max;
        }
    }

    public interface Converter<T, R> {
        R convert(T obj);
    }

    public static class MaxHolder<T extends Comparable<T>> {
        private T max;

        public MaxHolder(T max) {
            this.max = max;
        }

        public void setMax(T val) {
            if (max == null || val.compareTo(max) > 0) {
                max = val;
            }
        }

        public T getMax() {

            return max;
        }
    }

    interface StrictProcessor<T extends Serializable & Comparable<T>> {
        void process(T obj);
    }

    interface CollectionRepository<T , C extends Collection<T>> {
        void save(T entity);
        C getEntityCollection();
    }

    interface ListRepository<T> extends CollectionRepository<T, List<T>> {
        // No extra methods needed
    }

    interface ComparableCollection<E> extends Collection<E>, Comparable<Collection<?>> {
        @Override
        default int compareTo(Collection<?> o) {
            return Integer.compare(this.size(), o.size());
        }
    }

    static class CollectionUtil {

        public static <T> void print(List<T> list) {
            list.forEach(element -> System.out.println(" – " + element));
        }

        public static <T /*extends BaseEntity*/> boolean hasNewEntities(Collection<T> entities) {
            throw new UnsupportedOperationException("Implement using BaseEntity");
        }

        public static <T /*extends BaseEntity*/> boolean isValidCollection(Collection<T> entities, java.util.function.Predicate<T> validationPredicate) {
            // Example: return true if all entities pass the validation predicate
            // return entities.stream().allMatch(validationPredicate);
            throw new UnsupportedOperationException("Implement using BaseEntity");
        }

        public static <T /*extends BaseEntity*/> boolean hasDuplicates(List<T> entities, T targetEntity) {
            // Example: count how many times targetEntity appears in list
            // return entities.stream().filter(e -> e.getUuid().equals(targetEntity.getUuid())).count() > 1;
            throw new UnsupportedOperationException("Implement using BaseEntity");
        }

        public static <T> void swap(List<T> elements, int i, int j) {
            Objects.checkIndex(i, elements.size());
            Objects.checkIndex(j, elements.size());
            T temp = elements.get(i);
            elements.set(i, elements.get(j));
            elements.set(j, temp);
        }

        public static <T> T findMax(Iterable<T> elements, Comparator<T> comparator) {
            T max = null;
            for (T element : elements) {
                if (max == null || comparator.compare(element, max) > 0) {
                    max = element;
                }
            }
            if (max == null) {
                throw new NoSuchElementException("Iterable is empty");
            }
            return max;
        }

        public static <T> T findMostRecentlyCreatedEntity(Collection<T> entities, Comparator<T> createdOnComparator) {
            return findMax(entities, createdOnComparator);
        }
    }
    public static void main(String[] args) {

        // Sourced example
        CrazyGenerics.Sourced<String> sourcedString = new CrazyGenerics.Sourced<>("Hello World", "UserInput");
        CrazyGenerics.Sourced<Integer> sourcedInt = new CrazyGenerics.Sourced<>(100, "Sensor1");
        System.out.println("Sourced String: " + sourcedString.getValue() + " from " + sourcedString.getSource());
        System.out.println("Sourced Integer: " + sourcedInt.getValue() + " from " + sourcedInt.getSource());

        System.out.println("\n-------------------");

        // Limited example
        CrazyGenerics.Limited<Integer> limitedInt = new CrazyGenerics.Limited<>(75, 0, 100);
        CrazyGenerics.Limited<Double> limitedDouble = new CrazyGenerics.Limited<>(49.99, 0.0, 500.0);
        System.out.println("Limited Int: actual=" + limitedInt.getActual() + ", min=" + limitedInt.getMin() + ", max=" + limitedInt.getMax());
        System.out.println("Limited Double: actual=" + limitedDouble.getActual() + ", min=" + limitedDouble.getMin() + ", max=" + limitedDouble.getMax());

        System.out.println("\n-------------------");

        // MaxHolder example
        CrazyGenerics.MaxHolder<Integer> maxHolder = new CrazyGenerics.MaxHolder<>(10);
        maxHolder.setMax(20);
        maxHolder.setMax(15);
        System.out.println("MaxHolder Max: " + maxHolder.getMax());

        System.out.println("\n-------------------");

        // CollectionUtil.print & swap
        List<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie"));
        System.out.println("Original List:");
        CrazyGenerics.CollectionUtil.print(names);
        CrazyGenerics.CollectionUtil.swap(names, 0, 2);
        System.out.println("After Swap:");
        CrazyGenerics.CollectionUtil.print(names);

        System.out.println("\n-------------------");

        // findMax example
        List<Integer> numbers = Arrays.asList(10, 30, 20, 50, 40);
        Integer maxNumber = CrazyGenerics.CollectionUtil.findMax(numbers, Comparator.naturalOrder());
        System.out.println("Max Number: " + maxNumber);

        System.out.println("\n-------------------");

        // findMostRecentlyCreatedEntity example
        List<Person> people = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 20)
        );
        Person oldest = CrazyGenerics.CollectionUtil.findMostRecentlyCreatedEntity(
                people,
                Comparator.comparingInt(Person::getAge)
        );
        System.out.println("Oldest Person: " + oldest.getName() + ", Age: " + oldest.getAge());
    }

    // Helper class
    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
