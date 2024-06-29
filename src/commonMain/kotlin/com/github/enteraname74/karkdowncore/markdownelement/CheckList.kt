package com.github.enteraname74.karkdowncore.markdownelement

import com.github.enteraname74.karkdowncore.textutils.isCheckListBoxChecked

class CheckList(rowData: String, innerData: MarkdownElement): MarkdownElement(rowData = rowData) {
    override val viewData: MarkdownElement = innerData
    val isChecked: Boolean = rowData.isCheckListBoxChecked()

    override fun toString(): String {
        return "CheckList(\n\trowData = $rowData\n\tinnerData = $viewData\n)"
    }
}