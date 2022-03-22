package leetcode.medium

import printResult

fun main() {
    printResult(getSmallestString(n = 3, k = 27), "aay")
    printResult(getSmallestString(n = 3, k = 3), "aaa")
    printResult(getSmallestString(n = 5, k = 73), "aaszz")
}

private fun getSmallestString(n: Int, k: Int): String {
    var zCount = 0
    var left = k - n
    while (left > 25) {
        left -= 25
        zCount++
    }
    val aCount = n - zCount - 1
    val stringBuilder = StringBuilder()
    repeat(aCount) {
        stringBuilder.append('a')
    }
    stringBuilder.append('a' + left)
    repeat(zCount) {
        stringBuilder.append('z')
    }
    return stringBuilder.toString()
}
