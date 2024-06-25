package textutils

import model.textutils.headerContent
import model.textutils.isHeader
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class HeaderTests {
    @Test
    fun givenString_whenCheckIfHeader_thenShouldReturnCorrectValue() {
        assert("# header".isHeader())
        assert("### header".isHeader())
        assertFalse("not header".isHeader())
        assertFalse("#not header".isHeader())
    }

    @Test
    fun givenHeaderString_whenGetContent_thenShouldRetrieveInnerText() {
        assertEquals("Header string", "## Header string".headerContent())
        assertEquals("  Header string", "##   Header string".headerContent())
        assertEquals("-/Header string", "## -/Header string".headerContent())
    }
}