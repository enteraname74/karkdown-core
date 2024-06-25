package textutils

import model.textutils.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class UnorderedListTests {
    @Test
    fun givenString_whenCheckingIfUnorderedList_thenShouldReturnCorrectValue() {
        assert("- element".isUnorderedList())
        assert("* element".isUnorderedList())
        assert("+ element".isUnorderedList())
        assertFalse("-element".isUnorderedList())
        assertFalse("1. element".isUnorderedList())
        assertFalse("175. element".isUnorderedList())
    }

    @Test
    fun givenString_whenToUnorderedList_thenShouldBuildCorrectListValue() {
        assertEquals("+ list element", "list element".toUnorderedList("+"))
        assertEquals("- list element", "list element".toUnorderedList("-"))
        assertEquals("- ", "".toUnorderedList("-"))
    }

    @Test
    fun givenUnorderedListElement_whenGetContent_thenShouldRetrieveContent() {
        assertEquals("element", "- element".unorderedListContent())
        assertEquals("element", "+ element".unorderedListContent())
    }

    @Test
    fun givenUnorderedListElement_whenGetIndicator_thenShouldRetrieveIndicator() {
        assertEquals("+", "+ element".unorderedListIndicator())
        assertEquals("-", "- element".unorderedListIndicator())
        assertEquals("-", "element".unorderedListIndicator())
    }
}