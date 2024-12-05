package leetcode.easy

import tools.checkResult

fun main() {
//    checkResult(expected = "ball", actual = mostCommonWord(paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = arrayOf("hit")))
//    checkResult(expected = "a", actual = mostCommonWord(paragraph = "a.", banned = arrayOf()))
    checkResult(
        expected = "the",
        actual = mostCommonWord(paragraph = "abc abc? abcd the jeff!", banned = arrayOf("abc", "abcd", "jeff"))
    )
}

private fun mostCommonWord(paragraph: String, banned: Array<String>): String {
    val sb = StringBuilder()
    val map = HashMap<String, Int>()
    val banSet = banned.toHashSet()
    val range = 'A'..'z'
    for (c in paragraph) {
        val c = c.lowercaseChar()
        if (c in range) {
            sb.append(c)
            continue
        }
        if (sb.isNotEmpty()) {
            val s = sb.toString()
            if (!banSet.contains(s))
                map[s] = (map[s] ?: 0) + 1
            sb.clear()
        }
    }
    val s = sb.toString()
    if (sb.isNotEmpty() && !banSet.contains(s))
        map[s] = (map[s] ?: 0) + 1
    return map.entries.reduce { acc, entry ->
        if (acc.value > entry.value) acc else entry
    }.key
}
