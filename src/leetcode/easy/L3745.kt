package leetcode.easy

fun main() {

}


private fun maximizeExpressionOfThree(nums: IntArray): Int {
    var max = -100
    var next = -100
    var min = 100
    for (i in nums) {
        if (i > max) {
            next = max
            max = i
        }
        else if (i > next) {
            next = i
        }
        if (i < min) {
            min = i
        }
    }
    return max + next - min
}

private fun maximizeExpressionOfThree2(nums: IntArray): Int {
    nums.sort()
    return nums[nums.lastIndex] + nums[nums.lastIndex - 1] - nums[0]
}