package leetcode.easy

fun main() {
}

private fun largestPerimeter(nums: IntArray): Int {
    nums.sortDescending()
    for (i in 0..nums.lastIndex - 2) {
        if (nums[i] < nums[i + 1] + nums[i + 2])
            return nums[i] + nums[i + 1] + nums[i + 2]
    }
    return 0
}
