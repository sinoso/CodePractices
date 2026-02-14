package leetcode.easy

import java.util.*

fun main() {

}

private fun minOperations(logs: Array<String>): Int {
    var count = 0
    for (log in logs) {
        when (log) {
            "./" -> {}
            "../" -> if (count > 0) count--
            else -> count++
        }
    }
    return count
}

private fun minOperations2(logs: Array<String>): Int {
    val stack = Stack<String>()
    for (log in logs) {
        when (log) {
            "./" -> {}
            "../" -> {
                if (stack.isNotEmpty())
                    stack.pop()
            }

            else -> stack.push(log)
        }
    }
    return stack.size
}