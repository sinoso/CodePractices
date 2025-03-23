package leetcode.easy

import printResult


fun main() {
    printResult(actual = convertToBase7(100), expected = "202")
    printResult(actual = convertToBase7(-7), expected = "-10")
    printResult(actual = convertToBase7(-1), expected = "-1")
}

private fun convertToBase7(num: Int): String {
    val sb = StringBuilder()
    var left = num
    if (num < 0) {
        left *= -1
    }
    while (left > 6) {
        sb.insert(0, left % 7)
        left /= 7
    }
    sb.insert(0, left)
    if (num < 0) {
        sb.insert(0, '-')
    }
    return sb.toString()
}