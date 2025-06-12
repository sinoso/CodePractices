package leetcode.easy

import kotlin.math.abs

fun main() {

}

private fun maxAdjacentDistance(nums: IntArray): Int {
    var maxDiff = abs(nums.first() - nums.last())
    for (i in 1..nums.lastIndex) {
        maxDiff = maxDiff.coerceAtLeast(abs(nums[i] - nums[i - 1]))
    }
    return maxDiff
}