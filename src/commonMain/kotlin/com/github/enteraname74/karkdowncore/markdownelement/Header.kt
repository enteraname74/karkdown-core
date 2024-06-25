package com.github.enteraname74.karkdowncore.markdownelement

import com.github.enteraname74.karkdowncore.textutils.headerContent
import com.github.enteraname74.karkdowncore.textutils.headerLevel


/**
 * Represent a header with its level
 */
class Header(rowData: String) : MarkdownElement(rowData = rowData) {
    override val viewData: String = rowData.headerContent()
    val headerLevel = rowData.headerLevel()

    override fun toString(): String {
        return "Header(rowData = $rowData)"
    }
}