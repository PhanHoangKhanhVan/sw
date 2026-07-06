package com.system.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Equivalence classes for CompareHtmlContent.isIdentical(oldContent, newContent)
 *
 * EC1 - Same text, different HTML tags/formatting -> true (tags are stripped first)
 * EC2 - Same text, identical HTML tags            -> true
 * EC3 - Different visible text (tags stripped)    -> false
 * EC4 - No HTML tags at all (plain text)          -> behaves like plain equals()
 * EC5 - Empty tags only, e.g. "<br/>" vs ""        -> true (both reduce to "")
 * EC6 - null input                                -> NullPointerException
 */
public class CompareHtmlContentTest {

    private final CompareHtmlContent strategy = new CompareHtmlContent();

    @Test
    public void testSameTextDifferentTags_returnsTrue() {
        String oldHtml = "<p>Hello World</p>";
        String newHtml = "<div><b>Hello World</b></div>";
        assertTrue(strategy.isIdentical(oldHtml, newHtml)); //important assert
    }

    @Test
    public void testIdenticalHtml_returnsTrue() {
        String html = "<p>Same content</p>";
        assertTrue(strategy.isIdentical(html, html));
    }

    @Test
    public void testDifferentVisibleText_returnsFalse() {
        String oldHtml = "<p>Version 1</p>";
        String newHtml = "<p>Version 2</p>";
        assertFalse(strategy.isIdentical(oldHtml, newHtml));
    }

    @Test
    public void testPlainTextWithoutTags_behavesLikeEquals() {
        assertTrue(strategy.isIdentical("plain text", "plain text"));
        assertFalse(strategy.isIdentical("plain text", "other text"));
    }

    @Test
    public void testOnlyTagsReduceToEmptyString_returnsTrue() {
        assertTrue(strategy.isIdentical("<br/>", ""));
    }

    @Test(expected = NullPointerException.class)
    public void testNullNewContent_throwsException() {
        strategy.isIdentical("<p>abc</p>", null);
    }
}
