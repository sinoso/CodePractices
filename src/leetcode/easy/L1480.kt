package leetcode.easy

fun main() {

    println(runningSum(intArrayOf(1, 2, 3, 4)).contentToString()) //2


}

private fun runningSum(nums: IntArray): IntArray =
        nums.apply {
            for (i in 1..nums.lastIndex)
                this[i] += this[i - 1]
        }

private fun runningSum2(nums: IntArray): IntArray =
        IntArray(nums.size).apply {
            this[0] = nums[0]
            for (i in 1..nums.lastIndex)
                this[i] = this[i - 1] + nums[i]
        }

