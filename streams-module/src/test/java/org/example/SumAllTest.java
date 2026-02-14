package org.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SumAllTest {

    @Test
    void testSumAll() {
        List<Integer> nums = List.of(1,2,3,4);
        assertEquals(10, SumAll.sum(nums));
    }
}
