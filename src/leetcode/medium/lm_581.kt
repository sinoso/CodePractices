package leetcode.medium

import printResult

fun main() {
    printResult(findUnsortedSubarray(intArrayOf(2, 6, 4, 8, 10, 9, 15)), 5)
    printResult(findUnsortedSubarray(intArrayOf(6, 2, 4, 8, 10, 9, 15)), 6)
    printResult(findUnsortedSubarray(intArrayOf(6, 2, 4, 8, 10, 15, 9)), 7)
    printResult(findUnsortedSubarray(intArrayOf(1)), 0)
}

private fun findUnsortedSubarray(nums: IntArray): Int {
    var minIndex = nums.size
    var maxIndex = 0
    val sortedNums = nums.sorted()
    val range = nums.indices
    for (i in range) {
        if (nums[i] != sortedNums[i]) {
            minIndex = minIndex.coerceAtMost(i)
            maxIndex = maxIndex.coerceAtLeast(i)
        }
    }
    return if (maxIndex - minIndex >= 0) maxIndex - minIndex + 1 else 0
}
