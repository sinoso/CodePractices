package leetcode.medium

import printResult
import java.util.*

fun main() {
    printResult(find132pattern(intArrayOf(1, 2, 3, 4)), false)
    printResult(find132pattern(intArrayOf(3, 1, 4, 2)), true)
    printResult(find132pattern(intArrayOf(-2, 1, -2)), false)
    printResult(find132pattern(intArrayOf(3, 5, 0, 3, 4)), true)

}

private fun find132pattern(nums: IntArray): Boolean {
    val stack = Stack<Int>()
    var min = nums[0]
    val minArray = Array(nums.size) {
        min.coerceAtMost(nums[it])
            .also { minValue -> min = minValue }
    }
    for (i in nums.indices.reversed()) {
        if (stack.isNotEmpty() && nums[i] > minArray[i]) {
            while (stack.isNotEmpty() && stack.peek() <= minArray[i]) {
                stack.pop()
            }
            if (stack.size > 0 && nums[i] > stack.peek() && stack.peek() > minArray[i])
                return true
        }
        stack.push(nums[i])
    }
    return false
}

private fun find132patternBF(nums: IntArray): Boolean {//BF - TimeOut
    val lastIndex = nums.lastIndex
    for (i in 0..lastIndex - 2)
        for (j in (i + 1) until lastIndex)
            for (k in (j + 1)..lastIndex)
                if (nums[i] < nums[k] && nums[k] < nums[j])
                    return true
    return false
}
