package leetcode.easy

fun main() {
    println(intArrayOf(0, 1, 0, 3, 12).also { moveZeroes(it) }.joinToString())
//    println(intArrayOf(0).also { moveZeroes(it) }.joinToString())
//    println(intArrayOf(1, 2, 3, 4, 5, 6).also { moveZeroes(it) }.joinToString())
}

private fun moveZeroes(nums: IntArray): Unit { // 28.21 8.26
    var zeros = 0
    var left = 0
    for (i in nums.indices) {
        if (nums[i] != 0) {
            nums[left++] = nums[i]
            continue
        }
        zeros++
    }
    for (i in left..nums.lastIndex)
        nums[i] = 0
}