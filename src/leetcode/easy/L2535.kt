package leetcode.easy

fun main() {
    differenceOfSum(intArrayOf(1,2,3,4))
}

private fun differenceOfSum(nums: IntArray): Int {
    var eSum = 0
    var dSum = 0
    for (i in nums) {
        eSum += i
        var left = i
        while (left > 0) {
            dSum += left % 10
            left /= 10
        }
    }
    val sum = eSum - dSum
    return if (sum < 0) sum * -1 else sum
}


private fun differenceOfSum2(nums: IntArray): Int {
    val elementSum = nums.fold(0) { acc, i -> acc + i }
    val digitSum = nums.fold(0) { acc, i -> acc + i.toString().fold(0) { cAcc, c -> cAcc + (c - '0') } }
    val sum = elementSum - digitSum
    return if (sum < 0) sum * -1 else sum
}

