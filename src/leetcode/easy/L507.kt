package leetcode.easy

import tools.checkResult
import kotlin.math.ceil
import kotlin.math.sqrt

fun main() {
    checkResult(expected = true, actual = checkPerfectNumber(6))
//    checkResult(expected = true, actual = checkPerfectNumber(28))
//    checkResult(expected = false, actual = checkPerfectNumber(7))
//    checkResult(expected = false, actual = checkPerfectNumber(4))
}

private fun checkPerfectNumber(num: Int): Boolean {
    var sum = 1
    val lastValue = Math.sqrt(num.toDouble())
    val ceil = ceil(lastValue)
    if (lastValue == ceil) {
        sum -= ceil.toInt()
    }
    for (i in 2..lastValue.toInt()) {
        if (num % i == 0) {
            sum += i
            sum += num / i
        }
    }
    return sum == num
}