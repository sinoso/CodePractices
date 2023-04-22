package leetcode.easy

import printResult

fun main() {
    printResult(commonChars(arrayOf("bella", "label", "roller")), listOf("e", "l", "l"))
    printResult(commonChars(arrayOf("bel")), listOf("b", "e", "l"))
}

private fun commonChars(words: Array<String>): List<String> =
    words.map { it.groupingBy { char -> char }.eachCount() }
        .flatMap { it.entries }
        .groupBy { it.key }
        .filter { it.value.size == words.size }
        .map { it.key.toString() to it.value.fold(101) { acc, count -> acc.coerceAtMost(count.value) } }
        .flatMap { charEntries -> List(charEntries.second) { charEntries.first } }

