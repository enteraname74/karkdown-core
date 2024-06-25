package textutils

import model.textutils.isItalic
import model.textutils.italicContent
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class ItalicTests {
    @Test
    fun givenString_whenCheckIfItalic_thenShouldReturnCorrectValue() {
        assert("*italic*".isItalic())
        assertFalse("not italic".isItalic())
    }

    @Test
    fun givenBoldString_whenGetContent_thenShouldRetrieveInnerText() {
        val boldString = "*italic string*"
        assertEquals("italic string", boldString.italicContent())
    }}