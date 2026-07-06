package com.system.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Equivalence classes for CompareTextContent.isIdentical(oldContent, newContent)
 *
 * EC1 - Identical strings          -> true
 * EC2 - Different strings          -> false
 * EC3 - Same text, different case  -> false (String.equals is case-sensitive)
 * EC4 - Both empty strings         -> true
 * EC5 - null input                 -> NullPointerException
 */
public class CompareTextContentTest {

    private final CompareTextContent strategy = new CompareTextContent();

    @Test
    public void testIdenticalStrings_returnsTrue() {
        assertTrue(strategy.isIdentical("Hello Website", "Hello Website"));
    }

    @Test
    public void testDifferentStrings_returnsFalse() {
        assertFalse(strategy.isIdentical("Hello Website", "Goodbye Website"));
    }

    @Test
    public void testCaseSensitivity_returnsFalse() {
        assertFalse(strategy.isIdentical("Test", "test"));
    }

    @Test
    public void testBothEmpty_returnsTrue() {
        assertTrue(strategy.isIdentical("", ""));
    }

    @Test(expected = NullPointerException.class)
    public void testNullOldContent_throwsException() {
        strategy.isIdentical(null, "abc");
    }
}
