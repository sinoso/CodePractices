package leetcode.medium

import printResult
import java.util.*

fun main() {
    printResult(removeDuplicates(s = "abcd", k = 2), "abcd")
    printResult(removeDuplicates(s = "deeedbbcccbdaa", k = 3), "aa")

}

private fun removeDuplicates(s: String, k: Int): String {
    val sb = StringBuilder()
    val stack = Stack<Int>()
    val checkNum = k - 1
    s.forEach {
        if (sb.isNotEmpty() && sb.last() == it) {
            if (stack.peek() == checkNum) {
                sb.delete(sb.length - checkNum, sb.length)
                repeat(checkNum) { stack.pop() }
            } else {
                sb.append(it)
                stack.push(stack.peek() + 1)
            }
        } else {
            sb.append(it)
            stack.push(1)
        }
    }
    return sb.toString()
}
