package leetcode.easy

fun main() {

}

private fun findMaxConsecutiveOnes(nums: IntArray): Int {
    var count = 0
    var max = 0
    for (i in nums.indices) {
        if (nums[i] == 1)
            count++
        if (nums[i] == 0) {
            max = max.coerceAtLeast(count)
            count = 0
        }
    }
    return max.coerceAtLeast(count)
}
