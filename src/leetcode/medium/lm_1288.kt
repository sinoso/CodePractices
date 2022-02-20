package leetcode.medium
import printResult

fun main() {
    printResult(removeCoveredIntervals(arrayOf(intArrayOf(1, 4), intArrayOf(3, 6), intArrayOf(2, 8))), 2)
    printResult(removeCoveredIntervals(arrayOf(intArrayOf(1, 4), intArrayOf(2, 3))), 1)
    printResult(removeCoveredIntervals(arrayOf(intArrayOf(1, 2), intArrayOf(1, 4), intArrayOf(3, 4))), 1)
}

private fun removeCoveredIntervals(intervals: Array<IntArray>): Int {
    var removed = 0
    val sorted = intervals.sortedWith(compareBy<IntArray> { it[0] }.thenByDescending { it[1] })
    var current = sorted.first()
    for (i in 1..sorted.lastIndex) {
        if (current[0] <= sorted[i][0] && current[1] >= sorted[i][1]) {
            removed++
            continue
        }
        current = sorted[i]
    }
    return intervals.size - removed
}
