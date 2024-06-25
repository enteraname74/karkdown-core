package textutils

import model.textutils.isLink
import model.textutils.linkName
import model.textutils.linkUrl
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class LinkTests {
    @Test
    fun givenString_whenCheckingIfLink_thenShouldReturnCorrectValue() {
        assert("[link](url)".isLink())
        assertFalse("![link](url)".isLink())
    }

    @Test
    fun givenLink_whenGetName_thenShouldReturnLinkName() {
        assertEquals("link", "[link](url)".linkName())
    }

    @Test
    fun givenLink_whenGetUrl_thenShouldReturnLinkUrl() {
        assertEquals("url", "[link](url)".linkUrl())
    }
}