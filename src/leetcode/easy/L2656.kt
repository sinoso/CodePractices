package leetcode.easy

fun main() {

}

private fun maximizeSum(nums: IntArray, k: Int): Int {
    return nums.max() * k + (k - 1) * k / 2
}