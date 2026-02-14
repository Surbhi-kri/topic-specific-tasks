
package org.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FilterEvenTest {

    @Test
    void testFilterEven() {
        List<Integer> nums = List.of(1,2,3,4,5);
        assertEquals(List.of(2,4), FilterEven.filter(nums));
    }
}
