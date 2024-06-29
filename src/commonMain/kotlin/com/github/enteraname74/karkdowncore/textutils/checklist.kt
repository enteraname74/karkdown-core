package com.github.enteraname74.karkdowncore.textutils

/**
 * Check if a line is a checklist.
 */
fun String.isCheckList(): Boolean {
    val innerCheckBoxRegex = """[\s|x|X]"""
    val regex = Regex("""[-*+] \[$innerCheckBoxRegex] .*""")
    return regex.matches(this)
}

/**
 * Check if a checklist element is checked.
 */
fun String.isCheckListBoxChecked(): Boolean {
    val regex = Regex("""[-*+] (\[.]) .*""")
    val checkBox = regex.find(this)?.destructured?.toList()?.getOrNull(0) ?: return false
    val checkedBoxRegex = Regex("""\[x]|\[X]""")
    return checkedBoxRegex.matches(checkBox)
}

/**
 * Retrieve the content of a checklist.
 */
fun String.checkListContent(): String {
    val regex = Regex("""[-*+] \[.] (.*)""")
    return regex.find(this)?.destructured?.toList()?.getOrNull(0) ?: this
}

/**
 * Retrieve the indicator used to build the checklist.
 * If nothing is found, it returns the default indicator used, "-".
 */
fun String.checklistIndicator(): String {
    val regex = Regex("""([-*+]) \[.] .*""")
    return regex.find(this)?.destructured?.toList()?.getOrNull(0) ?: "-"
}