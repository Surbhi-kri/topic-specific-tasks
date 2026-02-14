package org.example;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoxTest {

    @Test
    void testBoxContent() {
        Box<String> stringBox = new Box<>("Hello");
        assertEquals("Hello", stringBox.getContent());

        Box<Integer> intBox = new Box<>(42);
        assertEquals(42, intBox.getContent());
    }

    @Test
    void testSetContent() {
        Box<String> box = new Box<>("Old");
        box.setContent("New");
        assertEquals("New", box.getContent());
    }
}