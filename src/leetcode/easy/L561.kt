package leetcode.easy

import printResult


fun main() {
    printResult(arrayPairSum(intArrayOf(1, 4, 3, 2)), 4)
}

private fun arrayPairSum(nums: IntArray): Int {
    nums.sort()
    var sum = 0
    for (i in nums.indices step 2) {
            sum += nums[i]
    }
    return sum
}

private fun arrayPairSum2(nums: IntArray): Int =
    nums.sorted().filterIndexed { index, _ -> index and 1 == 0 }.fold(0) { acc, i -> acc + i }
