package leetcode.easy

import tools.checkResult

fun main() {
    checkResult(expected = 1, dominantIndex(nums = intArrayOf(3, 6, 1, 0)))
    checkResult(expected = -1, dominantIndex(nums = intArrayOf(1, 2, 3, 4)))
    checkResult(expected = -1, dominantIndex(nums = intArrayOf(0, 2, 3, 0)))

}

private fun dominantIndex(nums: IntArray): Int {
    var first = if (nums[0] > nums[1]) 0 else 1
    var second = if (first == 0) 1 else 0
    for (i in 2..nums.lastIndex) {
        if (nums[i] > nums[second]) {
            second = i
        }
        if (nums[second] > nums[first]) {
            val temp = first
            first = second
            second = temp
        }
    }
    if (nums[first] >= (nums[second] * 2))
        return first
    else if (nums[second] >= (nums[first] * 2))
        return second
    return -1
}