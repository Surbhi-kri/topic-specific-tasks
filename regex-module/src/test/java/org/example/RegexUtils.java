package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RegexUtilsTest {

    @Test
    void testValidEmail() {
        assertTrue(RegexUtils.isValidEmail("test@gmail.com"));
        assertTrue(RegexUtils.isValidEmail("user.name123@yahoo.com"));
    }

    @Test
    void testInvalidEmail() {
        assertFalse(RegexUtils.isValidEmail("wrong-email"));
        assertFalse(RegexUtils.isValidEmail("abc@"));
        assertFalse(RegexUtils.isValidEmail(null));
    }

    @Test
    void testExtractNumbers() {
        List<String> result = RegexUtils.extractNumbers("abc123def45");

        assertEquals(2, result.size());
        assertEquals("123", result.get(0));
        assertEquals("45", result.get(1));
    }

    @Test
    void testNormalizeSpaces() {
        String result = RegexUtils.normalizeSpaces("  Hello    world   ");
        assertEquals("Hello world", result);
    }
}
