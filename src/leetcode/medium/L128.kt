package leetcode.medium

import printResult

fun main() {
    printResult(longestConsecutive(intArrayOf(100, 4, 200, 1, 3, 2)), 4)
}

private fun longestConsecutive(nums: IntArray): Int {
    if (nums.isEmpty())
        return 0
    nums.sort()
    var largest = 0
    var currentLargest = 1
    for (i in 0 until nums.lastIndex) {
        if (nums[i] == nums[i + 1] - 1) {
            currentLargest++
        } else if (nums[i] == nums[i + 1]) {
            continue
        } else {
            largest = largest.coerceAtLeast(currentLargest)
            currentLargest = 1
        }
    }
    return largest.coerceAtLeast(currentLargest)
}
