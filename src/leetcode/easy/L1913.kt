package leetcode.easy

fun main() {

}


private fun maxProductDifference(nums: IntArray): Int {
    nums.sort()
    val (num1, num2) = nums.take(2)
    val (num3, num4) = nums.takeLast(2)
    return num3 * num4 - num1 * num2
}
