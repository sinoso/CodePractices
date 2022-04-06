package leetcode.medium

import printResult

fun main() {
    printResult(minSteps(s = "bab", t = "aba"), 1)
    printResult(minSteps(s = "leetcode", t = "practice"), 5)
    printResult(minSteps("anagram", t = "mangaar"), 0)
}

private fun minSteps(s: String, t: String): Int {
    val sCounted = s.groupingBy { it }.eachCount()
    val tCounted = t.groupingBy { it }.eachCount()
    return s.length - sCounted.keys.fold(0) { acc: Int, key: Char -> acc + ( tCounted[key] ?: 0).coerceAtMost(sCounted[key]!!) }
}
