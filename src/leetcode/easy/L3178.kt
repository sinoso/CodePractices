package leetcode.easy

import tools.checkResult

fun main() {
}

private fun numberOfChild(n: Int, k: Int): Int {
    val isGoToN = ((k / (n - 1)) and 1) == 0
    return if (isGoToN) k % (n - 1) else n - k % (n - 1) - 1
}