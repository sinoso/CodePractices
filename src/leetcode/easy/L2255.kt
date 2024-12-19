package leetcode.easy

import tools.checkResult

fun main() {
    checkResult(expected = 3, actual = countPrefixes(arrayOf("a", "b", "c", "ab", "bc", "abc"), "abc"))
}

private fun countPrefixes(words: Array<String>, s: String): Int {
    var count = 0
    val sLength = s.length
    words.forEach {
        if (sLength < it.length) {
            return@forEach
        }
        for (i in it.indices) {
            if (it[i]!= s[i])
                return@forEach
        }
        count++
    }
    return count
}

private fun countPrefixes2(words: Array<String>, s: String): Int = words.count { s.startsWith(it) }

