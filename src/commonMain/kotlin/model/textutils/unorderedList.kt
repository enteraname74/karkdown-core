package model.textutils

/**
 * Check if a line is an unordered list.
 */
fun String.isUnorderedList(): Boolean {
    val regex = Regex("""^([-*+]) .*""")
    return regex.matches(this)
}

/**
 * Build a blockquote line from a given start quotes line.
 */
fun String.toUnorderedList(listIndicator: String): String =
    "$listIndicator $this"

/**
 * Retrieve the content of an unordered list to show to a user.
 */
fun String.unorderedListContent(): String {
    return this.replaceFirst("[+*-]".toRegex(), "").trimStart()
}

/**
 * Retrieve the indicator used by the user for an unordered list.
 * If nothing is found, it returns the default indicator used, "-".
 */
fun String.unorderedListIndicator(): String {
    val regex = Regex("""(.) .*""")
    return regex.find(this)?.destructured?.toList()?.get(0) ?: "-"
}