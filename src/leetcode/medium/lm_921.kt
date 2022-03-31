package leetcode.medium

import printResult
import java.util.*

fun main() {
    printResult(minAddToMakeValid("())"), 1)
    printResult(minAddToMakeValid("((("), 3)
}

private fun minAddToMakeValid(s: String): Int {
    val sLength = s.length
    var idx = 0
    val stack = Stack<Char>()
    while (idx < sLength) {
        if (stack.isNotEmpty() && s[idx] == ')' && stack.peek() == '(')
            stack.pop()
        else
            stack.push(s[idx])
        idx++
    }
    return stack.size
}
