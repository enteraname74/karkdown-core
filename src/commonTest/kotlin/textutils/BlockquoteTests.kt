package textutils

import model.textutils.isBlockquote
import kotlin.test.Test

internal class BlockquoteTests {

    @Test
    fun givenBlockquote_whenCheckIfBlockquote_thenShouldReturnTrue() {
        val simpleBlockquotes = "> Simple blockquote"
        assert(simpleBlockquotes.isBlockquote())
    }
}