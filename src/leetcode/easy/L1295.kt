package leetcode.easy

fun main() {
    println(findNumbers(intArrayOf(2, 3, 4, 6)))
}

private fun findNumbers(nums: IntArray): Int =
    nums.count {
        var left = it
        var count = 0
        while (left > 0) {
            count++
            left /= 10
        }
        (count and 1) == 0
    }