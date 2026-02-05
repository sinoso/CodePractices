package leetcode.easy

fun main() {

}

private fun sumOfDigits(nums: IntArray): Int {
    var min = nums.min()
    var sum = 0
    while (min > 0) {
        sum += min % 10
        min /= 10
    }
    return (sum + 1) and 1
}
