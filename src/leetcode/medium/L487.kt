package leetcode.medium

import printResult

fun main() {
    printResult(findMaxConsecutiveOnes(intArrayOf(1, 0, 1, 1, 0)), 4)
    printResult(findMaxConsecutiveOnes(intArrayOf(1, 0, 1, 1, 0, 1)), 4)
    printResult(findMaxConsecutiveOnes(intArrayOf(0, 1)), 2)
}

private fun findMaxConsecutiveOnes(nums: IntArray): Int {
    if (nums.size == 1)
        return 1
    var current = 0
    var max = 0
    var last = 0
    for (i in nums.indices) {
        if (nums[i] == 1) {
            current++
        } else {
            max = maxOf(max, last + current + 1)
            last = current
            current = 0
        }
    }
    if (current == nums.size)
        return current
    max = maxOf(max, last + current + 1)

    return max
}