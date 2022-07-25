package leetcode.medium

fun main() {
    searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 8)
    searchRange(intArrayOf(1, 2, 3), 1)
}

private fun searchRange(nums: IntArray, target: Int): IntArray {
    val leftIndex = searchLeft(nums, target)
    if (leftIndex == -1)
        return intArrayOf(-1, -1)
    return intArrayOf(leftIndex, searchRight(nums, target))
}

private fun searchLeft(nums: IntArray, target: Int): Int {
    var l = 0
    var r = nums.lastIndex
    var leftIndex = -1
    while (l <= r) {
        val mid = (l + r) / 2
        if (nums[mid] < target) {
            l = mid + 1
        } else if (nums[mid] > target) {
            r = mid - 1
        } else {
            leftIndex = mid
            r = mid - 1
        }
    }
    return leftIndex
}

private fun searchRight(nums: IntArray, target: Int): Int {
    var l = 0
    var r = nums.lastIndex
    var rightIndex = -1
    while (l <= r) {
        val mid = (l + r) / 2
        if (nums[mid] < target) {
            l = mid + 1
        } else if (nums[mid] > target) {
            r = mid - 1
        } else {
            rightIndex = mid
            l = mid + 1
        }
    }
    return rightIndex
}

