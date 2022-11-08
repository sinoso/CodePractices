package leetcode.easy

fun main() {

}

private fun divideArray(nums: IntArray): Boolean =
    nums.groupBy { it }.map { it.value }.find { it.size % 2 == 1 } == null
