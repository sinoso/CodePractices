package leetcode.hard

import printResult

fun main() {
    printResult(trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)), 6)
    printResult(trap(intArrayOf(4, 2, 0, 3, 2, 5)), 9)
    printResult(trap(intArrayOf(1, 1, 1)), 0)
    printResult(trap(intArrayOf(5, 5, 1, 7, 1, 1, 5, 2, 7, 6)), 23)
}


private fun trap(height: IntArray): Int {
    var left = 0
    var leftMax = height[left]
    var right = height.lastIndex
    var rightMax = height[right]
    var answer = 0
    while (left != right) {
        if (leftMax > rightMax) {
            if (height[right] > rightMax) {
                rightMax = height[right]
                continue
            }
            if (height[right] < rightMax) {
                answer += rightMax - height[right]
            }
            right--
        } else {
            if (height[left] > leftMax) {
                leftMax = height[left]
                continue
            }
            if (height[left] < leftMax) {
                answer += leftMax - height[left]
            }
            left++
        }
    }
    return answer
}

private fun trap2(height: IntArray): Int {
    var left = 0
    var leftMax = height[left]
    var right = height.lastIndex
    var rightMax = height[right]
    var answer = 0
    while (left != right) {
        if (leftMax > rightMax) {
            when {
                height[right] > rightMax -> {
                    rightMax = height[right]
                }
                height[right] < rightMax -> {
                    answer += rightMax - height[right]
                    right--
                }
                else -> right--
            }
        } else {
            when {
                height[left] > leftMax -> {
                    leftMax = height[left]
                }
                height[left] < leftMax -> {
                    answer += leftMax - height[left]
                    left++
                }
                else -> left++
            }
        }
    }
    return answer
}
