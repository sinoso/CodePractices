package leetcode.easy

import printResult

fun main() {
    printResult(thirdMax(intArrayOf(3, 2, 1)), 1)
    printResult(thirdMax(intArrayOf(1, 2)), 2)
}

private fun thirdMax(nums: IntArray): Int =
    nums.toSortedSet()
        .run {
            if (size >= 3)
                elementAt(size - 3)
            else last()
        }
