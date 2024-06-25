package textutils

import com.github.enteraname74.karkdowncore.textutils.imageName
import com.github.enteraname74.karkdowncore.textutils.imagePath
import com.github.enteraname74.karkdowncore.textutils.isImage
import com.github.enteraname74.karkdowncore.textutils.isURL
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class ImageTests {
    @Test
    fun givenString_whenCheckingIfIsImage_thenShouldReturnCorrectValue() {
        assert("![image](link)".isImage())
        assertFalse("[image](link)".isImage())
    }

    @Test
    fun givenImageString_whenGetImageImageName_thenShouldRetrieveImageName() {
        assertEquals("image", "![image](link)".imageName())
    }

    @Test
    fun givenImageString_whenGetImagePath_thenShouldRetrieveImagePath() {
        assertEquals("link", "![image](link)".imagePath())
    }

    @Test
    fun givenUrl_whenCheckingIfIsUrl_thenShouldReturnTrue() {
        assert("https://url.com".isURL())
        assert("http://url.com".isURL())
    }
}