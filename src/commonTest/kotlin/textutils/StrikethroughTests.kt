package textutils

import model.textutils.isStrikethrough
import model.textutils.strikethroughContent
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class StrikethroughTests {
    @Test
    fun givenString_whenCheckingIfStrikethrough_thenShouldReturnCorrectValue() {
        assert("~~strike~~".isStrikethrough())
        assertFalse("~strike~".isStrikethrough())
    }

    @Test
    fun givenStrikethrough_whenGetContent_thenShouldRetrieveContent() {
        assertEquals("strike element","~~strike element~~".strikethroughContent())
    }
}