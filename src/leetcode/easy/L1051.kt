package leetcode.easy

import printResult


fun main() {
//    printResult(heightChecker(intArrayOf(1, 1, 4, 2, 1, 3)), 3)
    printResult(heightChecker(intArrayOf(5, 1, 2, 3, 4)), 5)
}


private fun heightChecker(heights: IntArray): Int =
    heights.zip(heights.sorted())
        .filter { (default, sorted) ->
            default != sorted
        }
        .size

private fun heightChecker2(heights: IntArray): Int {
    val sorted = heights.sorted()
    var count = 0
    for (i in sorted.indices) {
        if (sorted[i] != heights[i])
            count++
    }
    return count
}
