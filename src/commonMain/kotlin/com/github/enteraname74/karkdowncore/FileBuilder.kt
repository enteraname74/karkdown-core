package com.github.enteraname74.karkdowncore

import com.github.enteraname74.karkdowncore.markdownelement.*
import com.github.enteraname74.karkdowncore.textutils.*

/**
 * Utils building a list of markdown elements from a row data.
 */
class FileBuilder {
    /**
     * Build a MarkdownElement from a given line.
     */
    private fun buildMarkdownElementFromLine(line: String): com.github.enteraname74.karkdowncore.markdownelement.MarkdownElement {
        return if (line.isHeader()) com.github.enteraname74.karkdowncore.markdownelement.Header(rowData = line)
        else if (line.isUnorderedList()) com.github.enteraname74.karkdowncore.markdownelement.UnorderedList(
            rowData = line,
            innerData = buildMarkdownElementFromLine(line.unorderedListContent())
        )
        else if (line.isOrderedList()) com.github.enteraname74.karkdowncore.markdownelement.OrderedList(
            rowData = line,
            innerData = buildMarkdownElementFromLine(line.orderedListContent())
        )
        else if (line.isBlockquote()) com.github.enteraname74.karkdowncore.markdownelement.Blockquote(
            rowData = line,
            innerData = buildMarkdownElementFromLine(line.blockquoteContent())
        )
        else if (line.isHorizontalRule()) com.github.enteraname74.karkdowncore.markdownelement.HorizontalRule(
            rowData = line
        )
        else if(line.isImage()) com.github.enteraname74.karkdowncore.markdownelement.Image(
            rowData = line
        )
        else com.github.enteraname74.karkdowncore.markdownelement.SimpleText(rowData = line)
    }

    /**
     * Build a markdown file from a list of lines.
     */
    fun buildMarkdownFile(lines: List<String>): ArrayList<com.github.enteraname74.karkdowncore.markdownelement.MarkdownElement> {
        val markdownFile: ArrayList<com.github.enteraname74.karkdowncore.markdownelement.MarkdownElement> = ArrayList()

        lines.forEach { line ->
            markdownFile.add(
                buildMarkdownElementFromLine(line = line)
            )
        }

//        markdownFile.forEach {
//            println(it)
//        }

        return markdownFile
    }
}