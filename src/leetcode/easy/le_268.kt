package leetcode.easy

fun main() {
    println(missingNumber(intArrayOf(3, 0, 1)))
    println(missingNumber(intArrayOf(0)))
}

private fun missingNumber(nums: IntArray): Int = (0..nums.size).sum() - nums.sum()

