package leetcode.medium

import printResult
import java.util.*


fun main() {
    printResult(reverseWords("  hello world  "), "world hello")
}

private fun reverseWords(s: String): String {
    val stack: Deque<String> = LinkedList()
    val sb = StringBuilder()
    var lastC = ' '
    for (c in s) {
        if (lastC == ' ' && c == ' ') {
            continue
        }
        if (c == ' ') {
            stack.offerFirst(sb.toString())
            sb.setLength(0)
        } else {
            sb.append(c)
        }
        lastC = c
    }
    if (sb.isNotEmpty())
        stack.offerFirst(sb.toString())
    return stack.joinToString(" ")
}

private fun reverseWords2(s: String): String =
    s.split(" ")
        .filter(String::isNotBlank)
        .reversed()
        .joinToString(" ")