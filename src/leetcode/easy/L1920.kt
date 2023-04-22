package leetcode.easy

fun main() {
    println(buildArray(intArrayOf(0, 2, 1, 5, 3, 4)).joinToString())
}


private fun buildArray(nums: IntArray): IntArray = nums.map { nums[it] }.toIntArray()

