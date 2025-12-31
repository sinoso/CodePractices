package leetcode.easy

import printResult


fun main() {
    printResult(expected = 10, actual = totalMoney(4))
    printResult(expected = 37, actual = totalMoney(10))
    printResult(expected = 96, actual = totalMoney(20))
    printResult(expected = 135, actual = totalMoney(26))
}

private fun totalMoney(n: Int): Int {
    val days = n % 7
    val weeks = n / 7

    val firstDay = 1 + weeks
    val lastDay = days + weeks
    val daysSum = (firstDay + lastDay) * days / 2

    val weekIncrementSum = weeks * (weeks - 1) / 2 * 7
    val weekBaseSum = 28 * weeks

    return daysSum + weekIncrementSum + weekBaseSum
}


