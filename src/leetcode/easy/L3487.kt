package leetcode.easy

fun main() {

}

private fun maxSum(nums: IntArray): Int {
    val set = nums.toSet()
    return if (set.any { it >= 0 }) {
        set.fold(initial = 0) { acc, i -> acc + if (i >= 0) i else 0 }
    } else
        set.maxOf { it }
}