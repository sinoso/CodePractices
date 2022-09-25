package leetcode.medium

import printResult


fun main() {
    printResult(jump(intArrayOf(2, 3, 1, 1, 4)), 2)
    printResult(jump(intArrayOf(1)), 0)
    printResult(jump(intArrayOf(2, 3, 0, 1, 4)), 2)
}

private fun jump(nums: IntArray): Int {
    val jumpAble = IntArray(nums.size)
    for (i in (nums.lastIndex - 1) downTo 0) {
        var min = 10001
        var index = i + 1
        val maxIndex = (i + nums[i]).coerceAtMost(nums.lastIndex)
        while (index <= maxIndex) {
            min = min.coerceAtMost(jumpAble[index])
            index++
        }
        jumpAble[i] = min + 1
    }
    return jumpAble[0]
}
