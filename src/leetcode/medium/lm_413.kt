package leetcode.medium

import printResult

fun main() {
    printResult(numberOfArithmeticSlices(intArrayOf(1, 2, 3, 4)), 3)
    printResult(numberOfArithmeticSlices(intArrayOf(7, 7, 7, 7)), 3)

}

private fun numberOfArithmeticSlices(nums: IntArray): Int {
    var answer = 0
    var count = 0
    var idx = 0
    while (idx < nums.lastIndex - 1) {
        if (nums[idx] - nums[idx + 1] == nums[idx + 1] - nums[idx + 2])
            count++
        else
            count = 0
        answer += count
        idx++
    }
    return answer
}
