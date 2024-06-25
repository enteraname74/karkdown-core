package com.github.enteraname74.karkdowncore.markdownelement

import com.github.enteraname74.karkdowncore.textutils.imageName
import com.github.enteraname74.karkdowncore.textutils.imagePath

/**
 * Represent an image information (name and path).
 */
class Image(rowData: String): MarkdownElement(rowData = rowData) {
    override val viewData: String = rowData
    val imageName: String = rowData.imageName()
    val imagePath: String = rowData.imagePath()
}