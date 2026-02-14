package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class NumericBoxTest {

    @Test
    void testDoubleValue() {
        NumericBox<Integer> intBox = new NumericBox<>(10);
        assertEquals(10.0, intBox.doubleValue());

        NumericBox<Double> doubleBox = new NumericBox<>(5.5);
        assertEquals(5.5, doubleBox.doubleValue());
    }

    @Test
    void testGetSetValue() {
        NumericBox<Integer> box = new NumericBox<>(1);
        box.setValue(99);
        assertEquals(99, box.getValue());
    }
}