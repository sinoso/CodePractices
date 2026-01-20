package leetcode.easy

fun main() {
}

private fun minMoves(nums: IntArray): Int {
    var sum = nums.first()
    var max = nums.first()
    for (i in 1..nums.lastIndex) {
        if (max < nums[i])
            max = nums[i]
        sum += nums[i]
    }
    return max * nums.size - sum
}