package leetcode.easy

fun main() {
    println(majorityElement(intArrayOf(3,2,3)))
}


private fun majorityElement(nums: IntArray): Int = nums.groupBy { it }.maxByOrNull { it.value.size }!!.key
