package leetcode.easy

import printResult

fun main() {
    printResult(canPlaceFlowers(intArrayOf(1, 0, 0, 0, 1), 1), true)
    printResult(canPlaceFlowers(intArrayOf(1, 0, 0, 0, 1), 2), false)
    printResult(canPlaceFlowers(intArrayOf(1, 0, 0, 0, 0, 1), 2), false)
    printResult(canPlaceFlowers(intArrayOf(0, 0, 1, 0, 1), 1), true)
    printResult(canPlaceFlowers(intArrayOf(1, 0, 1, 0, 0), 1), true)
}

private fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
    var count = 0
    var idx = 0
    var zeroCount = 1
    val max = flowerbed.size
    while (idx < max) {
        if (flowerbed[idx] == 0)
            zeroCount++
        else {
            if (zeroCount != 0)
                count += (zeroCount - 1 ushr 1)
            zeroCount = 0
        }
        idx++
    }
    if (zeroCount != 0)
        count += (zeroCount ushr 1)
    return count >= n
}
