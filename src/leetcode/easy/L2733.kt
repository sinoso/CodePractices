package leetcode.easy

fun main() {
    
}

private fun findNonMinOrMax(nums: IntArray): Int {
    if (nums.size <= 2) return -1
    return nums.take(3).sorted()[1]
}