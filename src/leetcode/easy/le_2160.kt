package leetcode.easy

import printResult

fun main() {
    printResult(minimumSum(2932), 52)
    printResult(minimumSum(4009), 13)
}

private fun minimumSum(num: Int): Int =
    num.toString()
        .map { (it - 48).toInt() }
        .sorted()
        .run { (this[0] + this[1]) * 10 + this[2] + this[3] }

