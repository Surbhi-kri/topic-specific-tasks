package org.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FilterContainsTest {

    @Test
    void testFilterContains() {
        List<String> words = List.of("apple","banana","apricot");
        assertEquals(List.of("apple","apricot"), FilterContains.filter(words,"ap"));
    }
}
