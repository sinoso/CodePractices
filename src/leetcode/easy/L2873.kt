package leetcode.easy

import printResult

fun main() {
    printResult(actual = maximumTripletValue(intArrayOf(8,6,3,13,2,12,19,5,19,6,10,11,9)), expected = 266)
}

private fun maximumTripletValue(nums: IntArray): Long {
    var largestDiff = 0
    var lastMax = Int.MIN_VALUE
    var answer = 0L
    for (i in 2..nums.lastIndex) {
        lastMax = lastMax.coerceAtLeast(nums[i - 2])
        largestDiff = largestDiff.coerceAtLeast(lastMax - nums[i - 1])
        answer = answer.coerceAtLeast((largestDiff) * 1L * nums[i])
    }
    return answer
}