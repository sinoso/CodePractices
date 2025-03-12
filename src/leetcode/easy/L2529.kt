package leetcode.easy

fun main() {

}

private fun maximumCount(nums: IntArray): Int {
    var negative = 0
    var positive = 0

    var index = 0
    while (index < nums.size) {
        if (nums[index] < 0) {
            negative++
        } else
            break
        index++
    }
    index = nums.lastIndex
    while (index > -1) {
        if (nums[index] > 0) {
            positive++
        } else
            break
        index--
    }
    return negative.coerceAtLeast(positive)
}
