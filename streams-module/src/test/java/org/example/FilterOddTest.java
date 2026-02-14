package org.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FilterOddTest {

    @Test
    void testFilterOdd() {
        List<Integer> nums = List.of(1,2,3,4,5);
        assertEquals(List.of(1,3,5), FilterOdd.filter(nums));
    }
}
