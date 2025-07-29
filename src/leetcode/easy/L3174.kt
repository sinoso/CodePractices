package leetcode.easy

import tools.checkResult
import java.util.Stack

fun main() {

}

private fun clearDigits(s: String): String {
    val stack = Stack<Char>()
    for (c in s) {
        if (stack.isEmpty())
            stack.push(c)
        else if (c.isDigit() && stack.peek().isLowerCase()) {
            stack.pop()
        } else if (c.isLowerCase() && stack.peek().isDigit()) {
            stack.pop()
        }else{
            stack.push(c)
        }
    }
    val sb = StringBuilder()

    while (stack.isNotEmpty()) {
        sb.append(stack.pop())
    }
    return sb.reversed().toString()
}