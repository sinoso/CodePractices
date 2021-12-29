package leetcode.easy

fun main() {
    println(maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
}

private fun maxSubArray(nums: IntArray): Int {
    for (i in 1..nums.lastIndex)
        nums[i] = nums[i].coerceAtLeast(nums[i] + nums[i - 1])
//    return nums.max()!!
    return nums.maxOrNull() ?: Int.MIN_VALUE
}

private fun maxSubArray2(nums: IntArray): Int { //TIME LIMIT OVER
    var answer = Int.MIN_VALUE
    for (startPoint in nums.indices) {
        var currentMax = 0
        for (numIdx in startPoint..nums.lastIndex) {
            currentMax += nums[numIdx]
            answer = answer.coerceAtLeast(currentMax)
        }
    }
    return answer
}
