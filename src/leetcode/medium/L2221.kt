package leetcode.medium

fun main() {

}

private fun triangularSum(nums: IntArray): Int {
    for (i in nums.lastIndex - 1 downTo 0) {
        for (j in 0..i) {
            nums[j] += nums[j + 1] % 10
        }
    }
    return nums.first()
}
