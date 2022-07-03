package leetcode.medium

import printResult

fun main() {
    printResult(wiggleMaxLength(intArrayOf(1, 7, 4, 9, 2, 5)), 6)
    printResult(wiggleMaxLength(intArrayOf(1, 1, 1, 1)), 1)
}

fun wiggleMaxLength(nums: IntArray): Int {
    var up = 1
    var down = 1
    for (i in 1..nums.lastIndex) {
        when {
            nums[i] > nums[i - 1] -> up = down + 1
            nums[i] < nums[i - 1] -> down = up + 1
        }
    }
    return down.coerceAtLeast(up)
}
