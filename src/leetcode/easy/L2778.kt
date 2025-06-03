package leetcode.easy

fun main() {
    sumOfSquares(intArrayOf(2,7,1,19,18,3))
}

private fun sumOfSquares(nums: IntArray): Int =
    nums.filterIndexed { index, _ -> nums.size % (index + 1) == 0 }.sumOf { it * it }