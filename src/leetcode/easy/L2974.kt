package leetcode.easy

fun main() {

}

private fun numberGame(nums: IntArray): IntArray {
    val sorted = nums.sorted()
    return IntArray(nums.size) { sorted[if (it % 2 == 0) it + 1 else it - 1] }
}