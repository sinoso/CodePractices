package leetcode.easy

import printResult

fun main() {
    printResult(numWaterBottles(9, 3), 13)
}

private fun numWaterBottles(numBottles: Int, numExchange: Int): Int {
    var sum = numBottles
    var emptyBottles = numBottles
    while (emptyBottles >= numExchange) {
        val new = emptyBottles / numExchange
        emptyBottles %= numExchange
        sum += new
        emptyBottles += new
    }
    return sum
}
