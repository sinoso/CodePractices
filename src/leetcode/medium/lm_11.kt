package leetcode.medium

import printResult

fun main() {
    printResult(maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)), 49)
    printResult(maxArea(intArrayOf(1, 1)), 1)
    printResult(maxArea(intArrayOf(1, 2, 1)), 2)
}

private fun maxArea(height: IntArray): Int {
    fun getArea(left: Int, right: Int) = height[left].coerceAtMost(height[right]) * (right - left)
    var left = 0
    var right = height.size - 1
    var maxSize = getArea(left, right)
    while (left < right) {
        if (height[left] < height[right])
            left++
        else
            right--
        maxSize = maxSize.coerceAtLeast(getArea(left, right))
    }
    return maxSize
}
