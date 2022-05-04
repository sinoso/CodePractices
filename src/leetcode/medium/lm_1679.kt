package leetcode.medium

import printResult


fun main() {
    printResult(maxOperations(intArrayOf(1, 2, 3, 4), 5), 2)
    printResult(maxOperations(intArrayOf(3, 1, 3, 4, 3), 6), 1)
}

private fun maxOperations(nums: IntArray, k: Int): Int {
    nums.sort()
    var count = 0
    var left = 0
    var right = nums.lastIndex
    var picked: Int
    while (left < right) {
        picked = nums[left] + nums[right]
        when {
            picked == k -> {
                count++
                left++
                right--
            }
            picked < k -> left++
            picked > k -> right--
        }
    }
    return count
}
