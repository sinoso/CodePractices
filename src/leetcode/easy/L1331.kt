package leetcode.easy

import printResult

fun main() {
    printResult(actual = arrayRankTransform(intArrayOf(40, 10, 20, 30)), expected = intArrayOf(4, 1, 2, 3))
    printResult(actual = arrayRankTransform(intArrayOf(40, 10, 20, 30)), expected = intArrayOf(4, 1, 2, 3))
}

private fun arrayRankTransform(arr: IntArray): IntArray {
    val map = arr.toSortedSet().withIndex().associate { it.value to it.index }
    for (i in arr.indices) {
        arr[i] = map[arr[i]]!! + 1
    }
    return arr
}