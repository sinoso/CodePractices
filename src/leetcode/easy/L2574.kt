package leetcode.easy


fun main() {
    leftRigthDifference(intArrayOf(10,4,8,3))
}

private fun leftRigthDifference(nums: IntArray): IntArray {
    var left = 0
    var current = 0
    var right = nums.sum()

    for (i in nums.indices) {
        left += current
        current = nums[i]
        right -= current
        nums[i] = Math.abs(left - right)
    }
    return nums
}