package org.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class UpperCaseAllTest {

    @Test
    void testUpperCaseAll() {
        List<String> words = List.of("hello","world");
        assertEquals(List.of("HELLO","WORLD"), UpperCaseAll.convert(words));
    }
}
