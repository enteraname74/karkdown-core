package textutils

import model.textutils.boldContent
import model.textutils.isBold
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class BoldTests {
    @Test
    fun givenString_whenCheckIfBold_thenShouldReturnCorrectValue() {
        assert("**bold**".isBold())
        assertFalse("notBold".isBold())
    }

    @Test
    fun givenBoldString_whenGetContent_thenShouldRetrieveInnerText() {
        val boldString = "**bold string**"
        assertEquals("bold string", boldString.boldContent())
    }
}