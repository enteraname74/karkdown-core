package textutils

import model.textutils.codeContent
import model.textutils.isCode
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class CodeTests {
    @Test
    fun givenString_whenCheckIfCode_thenShouldReturnCorrectValue() {
        assert("`code`".isCode())
        assert("``code``".isCode())
        assert("```code```".isCode())
        assertFalse("``not code`".isCode())
        assertFalse("not code".isCode())
    }

    @Test
    fun givenCodeString_whenGetContent_thenShouldRetrieveInnerText() {
        val codeString = "```Code string```"
        assertEquals("Code string", codeString.codeContent())
    }
}