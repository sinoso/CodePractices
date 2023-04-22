package leetcode.easy

import printResult

fun main() {
    printResult(minPartitions("32"), 3)
    printResult(minPartitions("27346209830709182346"), 9)
}

private fun minPartitions(n: String): Int {
    var max = 0
    for (c in n) {
        max = max.coerceAtLeast(c - '0')
        if (max == 9)
            return 9
    }
    return max
}
