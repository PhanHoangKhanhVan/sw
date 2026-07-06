package com.system.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Equivalence classes for CompareContentSize.isIdentical(oldContent, newContent)
 *
 * EC1 - Same length, same text            -> true
 * EC2 - Same length, different text       -> true (this reveals the weakness of the
 *                                             strategy: it only compares length!)
 * EC3 - Different length                  -> false
 * EC4 - Both empty strings ("" and "")    -> true (boundary case, length 0 == 0)
 * EC5 - null input                        -> NullPointerException (error condition)
 */
public class CompareContentSizeTest {

    private final CompareContentSize strategy = new CompareContentSize();

    @Test
    public void testSameLengthSameText_returnsTrue() {
        assertTrue(strategy.isIdentical("hello", "hello"));
    }

    @Test
    public void testSameLengthDifferentText_returnsTrue() {
        // Bug-revealing test case: length-only comparison cannot detect content changes
        // of equal length.
        assertTrue(strategy.isIdentical("abcde", "xyzab"));
    }

    @Test
    public void testDifferentLength_returnsFalse() {
        assertFalse(strategy.isIdentical("short", "a much longer string"));
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