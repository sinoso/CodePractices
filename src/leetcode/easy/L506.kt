package leetcode.easy

import tools.checkResult

fun main() {
    checkResult(
        expected = arrayOf("Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"),
        actual = findRelativeRanks(score = intArrayOf(5, 4, 3, 2, 1))
    )
    checkResult(
        expected = arrayOf("Gold Medal", "5", "Bronze Medal", "Silver Medal", "4"),
        actual = findRelativeRanks(score = intArrayOf(10, 3, 8, 9, 4))
    )
}

private fun findRelativeRanks(score: IntArray): Array<String> {
    val sorted = score.withIndex().sortedByDescending { it.value }
    val result: Array<String> = Array(score.size) { "" }
    sorted.forEachIndexed { index, indexedValue ->
        result[indexedValue.index] = when (index) {
            0 -> "Gold Medal"
            1 -> "Silver Medal"
            2 -> "Bronze Medal"
            else -> (index + 1).toString()
        }
    }
    return result
}