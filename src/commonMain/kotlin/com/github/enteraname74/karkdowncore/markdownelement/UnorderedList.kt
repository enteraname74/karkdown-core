package com.github.enteraname74.karkdowncore.markdownelement

import com.github.enteraname74.karkdowncore.textutils.unorderedListIndicator

/**
 * Represent an unordered list.
 */
class UnorderedList(rowData: String, innerData: MarkdownElement): MarkdownElement(rowData = rowData) {
    override val viewData: MarkdownElement = innerData
    val listIndicator: String = rowData.unorderedListIndicator()

    override fun toString(): String {
        return "UnorderedList(\n\trowData = $rowData\n\tinnerData = $viewData\n)"
    }
}