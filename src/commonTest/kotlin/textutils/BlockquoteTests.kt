package textutils

import model.textutils.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

internal class BlockquoteTests {

    @Test
    fun givenBlockquote_whenCheckIfBlockquote_thenShouldReturnCorrectValue() {
        val simpleBlockquotes = "> Simple blockquote"
        assert(simpleBlockquotes.isBlockquote())

        val nestedBlockquotes = ">>> Nested blockquote"
        assert(nestedBlockquotes.isBlockquote())

        val notBlockquote = "Hello world!"
        assertFalse(notBlockquote.isBlockquote())
    }

    @Test
    fun givenBlockquote_whenRetrievingLevel_thenShouldMatchBlockquoteLevel() {
        val blockquote = ">>> Blockquote"
        val level = blockquote.blockquoteLevel()

        assertEquals(3, level, "Blockquote level is not matching")
    }

    @Test
    fun givenBlockquote_whenRetrievingQuotes_thenShouldMatchLineQuote() {
        val blockquote = ">>> >Blockquote"
        val quotes = blockquote.blockquoteQuotes()

        assertEquals(">>>", quotes, "The line's quotes is not correct")
    }

    @Test
    fun givenBlockquote_whenRetrievingContent_thenShouldGetContentOrNextBlockquote() {
        val simple = "> Simple blockquote"
        val simpleContent = simple.blockquoteContent()

        assertEquals("Simple blockquote", simpleContent, "The content of the blockquote is not matching")

        val blockquote = ">>> Nested blockquote"
        val content = blockquote.blockquoteContent()

        assertEquals(">> Nested blockquote", content, "The content of the blockquote is not matching")
    }

    @Test
    fun givenBlockquote_whenRetrievingInnerText_thenShouldRetrieveOnlyTextOfTheBlockquote() {
        val simple = "> Simple blockquote"
        val simpleContent = simple.blockquoteInnerText()

        assertEquals("Simple blockquote", simpleContent, "The inner text of the blockquote is not matching")

        val blockquote = ">>> ## Nested blockquote"
        val content = blockquote.blockquoteInnerText()

        assertEquals("## Nested blockquote", content, "The inner text of the blockquote is not matching")
    }

    @Test
    fun givenAString_whenBuildingABlockquoteFromIt_thenShouldRetrieveCorrectlyFormattedBlockquote() {
        val emptyString = ""
        assertEquals("> ", emptyString.toBlockQuote(), "The empty blockquote is not correct")

        val simpleText = "**my text**"
        assertEquals("> **my text**", simpleText.toBlockQuote(), "The blockquote is not matching")

        val blockquote = ">> Blockquote"
        assertEquals(">>> Blockquote", blockquote.toBlockQuote(), "The blockquote is not matching")
    }
}