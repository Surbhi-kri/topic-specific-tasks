package org.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SquareAllTest {

    @Test
    void testSquareAll() {
        List<Integer> nums = List.of(1,2,3);
        assertEquals(List.of(1,4,9), SquareAll.square(nums));
    }
}
