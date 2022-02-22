package leetcode.easy

import printResult

fun main() {
    printResult(titleToNumber(columnTitle = "A"), 1)
    printResult(titleToNumber(columnTitle = "AB"), 28)
    printResult(titleToNumber(columnTitle = "ZY"), 701)
}

private fun titleToNumber(columnTitle: String): Int =
    columnTitle.fold(0) { acc, char -> acc * 26 + (char - '@') }

private fun titleToNumber2(columnTitle: String): Int {
    var answer = 0
    for (char in columnTitle) {
        answer *= 26
        answer += (char - '@')
    }
    return answer
}

private fun titleToNumber3(columnTitle: String): Int {
    var multi = 1
    var answer = 0
    for (i in columnTitle.indices.reversed()) {
        answer += (columnTitle[i] - '@') * multi
        multi *= 26
    }
    return answer
}

private fun titleToNumber4(columnTitle: String): Int {
    val multiGap = 26
    var multi = 1
    val padding = '@'
    var answer = 0
    for (char in columnTitle.reversed()) {
        answer += (char - padding) * multi
        multi *= multiGap
    }
    return answer
}
