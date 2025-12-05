package leetcode.easy

fun main() {
    countPartitions3(intArrayOf(2, 1))
}

private fun countPartitions(nums: IntArray): Int {
    var count = 0
    var leftSum = 0
    var rightSum = nums.sum()
    for (i in 0 until nums.lastIndex) {
        leftSum += nums[i]
        rightSum -= nums[i]
        if ((leftSum - rightSum) and 1 == 0)
            count++
    }
    return count
}
private fun countPartitions2(nums: IntArray): Int =
    if (nums.count { it and 1 == 1 } and 1 == 0)
        nums.size - 1 else 0

private fun countPartitions3(nums: IntArray): Int =
    nums.fold(initial = true) { acc, i -> acc xor (i and 1 == 1) }
        .let { if (it) nums.size - 1 else 0 }