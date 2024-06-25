package com.github.enteraname74.karkdowncore

import com.github.enteraname74.karkdowncore.textutils.blockquoteInnerText

/**
 * Format a file content to respect the markdown properties and to keep only the interesting information for the user
 * when editing the file.
 */
class FileFormatter {

    /**
     * Check if we should add a dummy space between two markdown elements.
     * We only add a dummy space if there is two consecutive simple text.
     */
    private fun addDummySpaceIfNecessary(pos: Int, rowData: ArrayList<String>, elements: List<com.github.enteraname74.karkdowncore.markdownelement.MarkdownElement>) {

        val isTwoSpecificMarkdownElements =
            (isSimpleText(pos, elements) || isList(pos, elements)) && isSimpleText(pos + 1, elements)

        if (isTwoSpecificMarkdownElements) {
            val isTwoNotBlankMarkdownElements =
                elements[pos].rowData.isNotBlank() && elements[pos + 1].rowData.isNotBlank()
            if (isTwoNotBlankMarkdownElements) rowData.add("")
        }
    }

    /**
     * Check if we should add a dummy blockquote between two markdown elements.
     * We only add a dummy space if there is two consecutive blockquotes with the same level.
     */
    private fun addDummyBlockquoteIsNecessary(pos: Int, rowData: ArrayList<String>, elements: List<com.github.enteraname74.karkdowncore.markdownelement.MarkdownElement>) {
        if (isBlockquote(pos, elements) && isBlockquote(pos + 1, elements)) {
            val b1 = elements[pos] as com.github.enteraname74.karkdowncore.markdownelement.Blockquote
            val b2 = elements[pos + 1] as com.github.enteraname74.karkdowncore.markdownelement.Blockquote

            if (b1.level >= b2.level) {
                rowData.add(b2.quotes)
            }
        }
    }

    /**
     * Check if a position in a list of markdown elements is a list.
     */
    private fun isList(pos: Int, elements: List<com.github.enteraname74.karkdowncore.markdownelement.MarkdownElement>): Boolean {
        if (pos >= elements.size || pos < 0) return false

        val element = elements[pos]

        return element is com.github.enteraname74.karkdowncore.markdownelement.UnorderedList || element is com.github.enteraname74.karkdowncore.markdownelement.OrderedList
    }

    /**
     * Check if a position in a list of markdown elements is a simple text.
     */
    private fun isSimpleText(pos: Int, elements: List<com.github.enteraname74.karkdowncore.markdownelement.MarkdownElement>): Boolean {
        if (pos >= elements.size || pos < 0) return false

        val element = elements[pos]

        return element is com.github.enteraname74.karkdowncore.markdownelement.SimpleText
    }

    /**
     * Check if a position in a list of markdown elements is a blockquote.
     */
    private fun isBlockquote(pos: Int, elements: List<com.github.enteraname74.karkdowncore.markdownelement.MarkdownElement>): Boolean {
        if (pos >= elements.size || pos < 0) return false

        val element = elements[pos]

        return element is com.github.enteraname74.karkdowncore.markdownelement.Blockquote
    }

    /**
     * Check if an element at a given position is a dummy space.
     */
    private fun isDummySpace(pos: Int, elements: List<com.github.enteraname74.karkdowncore.markdownelement.MarkdownElement>): Boolean {
        if (!isSimpleText(pos, elements)) return false

        val isPreviousElementInNeedOfSeparation =
            (isSimpleText(pos - 1, elements) || isList(pos - 1, elements))
                    && elements.getOrNull(pos - 1)?.rowData?.isNotBlank() == true
        val isTextBlank = elements[pos].rowData.isBlank()
        val isNextElementInNeedOfSeparation =
            isSimpleText(pos + 1, elements) && elements.getOrNull(pos + 1)?.rowData?.isNotBlank() == true

        return isPreviousElementInNeedOfSeparation && isNextElementInNeedOfSeparation && isTextBlank
    }

    /**
     * Check if an element at a given position is a dummy blockquote.
     */
    private fun isDummyBlockquote(pos: Int, elements: List<com.github.enteraname74.karkdowncore.markdownelement.MarkdownElement>): Boolean {

        if (isBlockquote(pos - 1, elements) && isBlockquote(pos + 1, elements)) {
            if (isBlockquote(pos, elements) || isSimpleText(pos, elements)) {
                return elements[pos].rowData.blockquoteInnerText().isBlank()
            }
        }
        return false
    }


    /**
     * Build a row data depending on a given list of markdown elements.
     * The final data is formatted to better suit the markdown conventions.
     */
    fun buildFinalRowData(elements: List<com.github.enteraname74.karkdowncore.markdownelement.MarkdownElement>): List<String> {
        val rowData = ArrayList<String>()

        elements.forEachIndexed { index, markdownElement ->
            rowData.add(markdownElement.rowData)
            addDummySpaceIfNecessary(
                pos = index,
                rowData = rowData,
                elements = elements
            )
            addDummyBlockquoteIsNecessary(
                pos = index,
                rowData = rowData,
                elements = elements
            )
        }

        return rowData
    }

    /**
     * Format a given list of markdown element for a user.
     */
    fun formatMarkdownElements(elements: List<com.github.enteraname74.karkdowncore.markdownelement.MarkdownElement>): ArrayList<com.github.enteraname74.karkdowncore.markdownelement.MarkdownElement> {
        val formattedElements = ArrayList<com.github.enteraname74.karkdowncore.markdownelement.MarkdownElement>()

        elements.forEachIndexed { index, markdownElement ->
            if (!isDummySpace(index, elements) && !isDummyBlockquote(index, elements)) {
                formattedElements.add(markdownElement)
            }
        }

        return formattedElements
    }
}