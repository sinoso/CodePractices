package leetcode.easy

import tools.checkResult

fun main() {
    checkResult(expected = 13, scoreOfString(s = "hello"))
    checkResult(expected = 50, scoreOfString(s = "zaz"))

}

private fun scoreOfString(s: String): Int {
    var sum = 0
    for (i in 0 until s.lastIndex) {
        sum += Math.abs(s[i] - s[i + 1])
    }
    return sum
}