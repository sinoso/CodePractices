package leetcode.easy

import printResult

fun main() {
    printResult(maxProduct(intArrayOf(3, 4, 5, 2)), 12)
    printResult(maxProduct(intArrayOf(1, 5, 4, 5)), 16)
    printResult(maxProduct(intArrayOf(3, 7)), 12)
}

private fun maxProduct(nums: IntArray): Int =
    nums.sorted().takeLast(2).fold(1) { acc, i -> acc * (i - 1) }

