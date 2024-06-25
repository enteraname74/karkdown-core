package textutils

import com.github.enteraname74.karkdowncore.textutils.isHorizontalRule
import kotlin.test.Test
import kotlin.test.assertFalse

class HorizontalRuleTests {
    @Test
    fun givenString_whenCheckingIfHorizontalRule_thenShouldReturnCorrectValue() {
        assert("***".isHorizontalRule())
        assert("---".isHorizontalRule())
        assertFalse("not horizontal rule".isHorizontalRule())
    }
}