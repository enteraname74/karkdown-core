package textutils

import model.textutils.boldAndItalicContent
import model.textutils.isBoldAndItalic
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class BoldAndItalicTests {
    @Test
    fun givenString_whenCheckIfBoldAndItalic_thenShouldReturnCorrectValue() {
        assert("***bold and italic***".isBoldAndItalic())
        assertFalse("notBoldAndItalic".isBoldAndItalic())
        assertFalse("** not italic or bold **".isBoldAndItalic())
    }

    @Test
    fun givenBoldAndItalicString_whenGetContent_thenShouldRetrieveInnerText() {
        val boldAndItalicString = "***bold and italic string***"
        assertEquals("bold and italic string", boldAndItalicString.boldAndItalicContent())
    }
}