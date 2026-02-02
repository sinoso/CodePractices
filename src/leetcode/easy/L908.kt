package leetcode.easy

fun main() {

}

private fun smallestRangeI(nums: IntArray, k: Int): Int {
    nums.sort()
    val min = nums.first()
    val max = nums.last()
    return (max - min - 2 * k).coerceAtLeast(0)
}