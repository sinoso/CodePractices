package leetcode.easy

import printResult

fun main() {
    printResult(countOdds(low = 3, high = 7), 3)
    printResult(countOdds(low = 8, high = 10), 1)
    printResult(countOdds(low = 8, high = 8), 0)
    printResult(countOdds(low = 9, high = 9), 1)
}

private fun countOdds(low: Int, high: Int): Int =
    (high - low + (if ((low and 1) == 1) 2 else 1)) / 2


// 3 (4 5 6 7) (7-3 +2)/2 == (high -low +2)/2
// 2 (3 4 5 6) 5/2 == (6-2 + 1)/2 == (high-low +1)/2
// 2 (3 4 5)
