package leetcode.easy

import printResult

fun main() {
    printResult(actual = uniqueOccurrences(intArrayOf(1, 2, 2, 1, 1, 3)), expected = true)
    printResult(actual = uniqueOccurrences(intArrayOf(1, 2)), expected = false)
    printResult(actual = uniqueOccurrences(intArrayOf(-3, 0, 1, -3, 1, 1, 1, -3, 10, 0)), expected = true)
}

private fun uniqueOccurrences(arr: IntArray): Boolean =
    arr.toSet().size == arr.groupBy { it }.map { it.value.size }.toHashSet().size
