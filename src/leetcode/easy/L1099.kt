package leetcode.easy

fun main() {
}

private fun twoSumLessThanK(nums: IntArray, k: Int): Int {//brute
    var max = -1
    val lastIndex = nums.lastIndex
    for (left in nums.indices) {
        for (right in left + 1..lastIndex) {
            val sum = nums[left] + nums[right]
            if (sum in (max + 1) until k)
                max = sum
        }
    }
    return max
}
