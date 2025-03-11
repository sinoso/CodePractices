package leetcode.easy

import printResult

fun main() {
    printResult(expected = "bacdfeg", actual = reverseStr(s = "abcdefg", k = 2))
    printResult(expected = "bacd", actual = reverseStr(s = "abcd", k = 2))
}

private fun reverseStr(s: String, k: Int): String {
    val table = s.toCharArray()
    for (i in 0..s.lastIndex step 2 * k) {
        val endPoint = (i + k - 1).coerceAtMost(s.lastIndex)
        val range = (endPoint - i)
        for (j in 0..range) {
            table[i + j] = s[i + range - j]
        }
    }
    return String(table)
}

private fun reverseStr2(s: String, k: Int): String = s.chunked(k)
    .mapIndexed { index, s ->
        if (index and 1 != 1)
            s.reversed()
        else
            s
    }.joinToString("")
