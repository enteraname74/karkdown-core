package textutils

import model.textutils.isOrderedList
import model.textutils.orderedListContent
import model.textutils.orderedListIndicator
import model.textutils.toOrderedList
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class OrderedListTests {
    @Test
    fun givenString_whenCheckingIfOrderedList_thenShouldReturnCorrectValue() {
        assert("1. element".isOrderedList())
        assert("174. element".isOrderedList())
        assertFalse("1.element".isOrderedList())
        assertFalse("- element".isOrderedList())
        assertFalse("-element".isOrderedList())
    }

    @Test
    fun givenString_whenToOrderedList_thenShouldBuildCorrectListValue() {
        assertEquals("1. list element", "list element".toOrderedList(1))
        assertEquals("1. ", "".toOrderedList(1))
    }

    @Test
    fun givenOrderedListElement_whenGetContent_thenShouldRetrieveContent() {
        assertEquals("element", "1. element".orderedListContent())
        assertEquals("element", "145. element".orderedListContent())
    }

    @Test
    fun givenOrderedListElement_whenGetIndicator_thenShouldRetrieveIndicator() {
        assertEquals(1, "1. element".orderedListIndicator())
        assertEquals(125, "125. element".orderedListIndicator())
    }
}