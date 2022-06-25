package leetcode.medium

import printResult


fun main() {
    printResult(checkPossibility(intArrayOf(4, 2, 3)), true)
    printResult(checkPossibility(intArrayOf(3, 4, 2, 3)), false)
    printResult(checkPossibility(intArrayOf(5, 7, 1, 8)), true)
    printResult(checkPossibility(intArrayOf(1, 2, 4, 5, 3)), true)
}

private fun checkPossibility(nums: IntArray): Boolean {
    var flag = false
    var i = 0
    val lastIndex = nums.lastIndex
    while (i < lastIndex) {
        if (nums[i] > nums[i + 1]) {
            if (flag)
                return false
            flag = true
            if (i > 0) {
                if (i + 2 <= lastIndex && nums[i] < nums[i + 2]) {
                    nums[i + 1] = nums[i]
                } else if (i + 1 == lastIndex) {
                    nums[i + 1] = nums[i]
                } else {
                    nums[i] = nums[i - 1]
                }
                continue
            }
        }
        i++
    }
    return true
}
