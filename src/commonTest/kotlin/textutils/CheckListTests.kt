package textutils

import com.github.enteraname74.karkdowncore.textutils.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class CheckListTests {
    @Test
    fun givenString_whenCheckingIfCheckList_thenShouldReturnCorrectValue() {
        assert("- [x] elt".isCheckList())
        assert("* [ ] elt".isCheckList())
        assert("+ [X] elt".isCheckList())
        assertFalse("-[ ] elt".isCheckList())
        assertFalse("- [] elt".isCheckList())
        assertFalse("- [ ]elt".isCheckList())
        assertFalse("- [o] elt".isCheckList())
    }

    @Test
    fun givenCheckListString_whenCheckIfBoxChecked_thenShouldReturnCorrectValue() {
        assert("- [x] hello".isCheckListBoxChecked())
        assert("- [X] hello".isCheckListBoxChecked())
        assertFalse("- [o] hello".isCheckListBoxChecked())
        assertFalse("- [ ] hello".isCheckListBoxChecked())
        assertFalse("- [] hello".isCheckListBoxChecked())
    }

    @Test
    fun givenCheckListElement_whenGetContent_thenShouldRetrieveContent() {
        assertEquals("element", "- [ ] element".checkListContent())
        assertEquals("element", "+ [x] element".checkListContent())
    }

    @Test
    fun givenOrderedListElement_whenGetIndicator_thenShouldRetrieveIndicator() {
        assertEquals("-", "- [ ] element".checklistIndicator())
        assertEquals("+", "+ [x] element".checklistIndicator())
        assertEquals("*", "* [X] element".checklistIndicator())
    }
}