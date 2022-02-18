package leetcode.medium

import printResult
import java.util.*

fun main() {
    printResult(removeKdigits("1432219", k = 3), "1219")
    printResult(removeKdigits("1023111", k = 3), "111")
    printResult(removeKdigits("10200", k = 1), "200")
    printResult(removeKdigits("10", k = 2), "0")
    printResult(removeKdigits("10", k = 2), "0")
}

private fun removeKdigits(num: String, k: Int): String {
    val sb = StringBuilder(num)
    var idx = 0
    var removed = 0
    val smallerStack = Stack<Pair<Int, Char>>()
    while (idx < sb.length && removed < k) {
        if (smallerStack.isEmpty() || (smallerStack.peek().second <= sb[idx])) {
            smallerStack.push(idx to sb[idx])
            idx++
            continue
        }
        sb.deleteCharAt(smallerStack.pop().first)
        idx--
        removed++
    }
    if (removed < k) {
        repeat(k - removed) {
            sb.deleteCharAt(sb.lastIndex)
        }
    }
    with(sb.trimStart { it == '0' }) {
        if (isEmpty()) return "0"
        return toString()
    }
}
