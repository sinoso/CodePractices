package leetcode.easy

import printResult


fun main() {
    printResult(threeConsecutiveOdds(intArrayOf(2, 6, 4, 1)), false)
    printResult(threeConsecutiveOdds(intArrayOf(1, 2, 34, 3, 4, 5, 7, 23, 12)), true)
}

private fun threeConsecutiveOdds(arr: IntArray): Boolean =
    arr.map { it and 1 == 1 }
        .fold(0) { acc, b -> if (acc > 2) acc else if (b) acc + 1 else 0 } == 3


private fun threeConsecutiveOdds2(arr: IntArray): Boolean {
    var count = 0
    for (i in arr) {
        if (i and 1 == 1)
            count++
        else
            count = 0
        if (count == 3)
            return true
    }
    return false
}
