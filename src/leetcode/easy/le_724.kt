package leetcode.easy


fun main() {
    println(pivotIndex(intArrayOf(1, 7, 3, 6, 5, 6)))
    println(pivotIndex(intArrayOf(1, 2, 3)))
    println(pivotIndex(intArrayOf(2, 1, -1)))
}

private fun pivotIndex(nums: IntArray): Int {
    var left = 0
    var right = nums.sum() - nums[0]
    for (i in 0 until nums.lastIndex) {
        if (left == right)
            return i
        left += nums[i]
        right -= nums[i + 1]
    }
    if (left == right)
        return nums.lastIndex
    return -1
}
