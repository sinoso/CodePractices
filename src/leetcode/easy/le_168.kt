package leetcode.easy

import printResult

fun main() {
    printResult(convertToTitle(1), "A")
    printResult(convertToTitle(28), "AB")
    printResult(convertToTitle(701), "ZY")
    printResult(convertToTitle(703), "AAA")
}

private fun convertToTitle(columnNumber: Int): String {
    var left = columnNumber
    val sb = StringBuilder()
    while (left > 0) {
        val current = (left % 26).let { if(it==0)'Z' else '@'+it}
        sb.insert(0,current)
        left--
        left /= 26
    }
    return sb.toString()
}
