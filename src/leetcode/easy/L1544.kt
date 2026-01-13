package leetcode.easy

import java.util.*
import kotlin.math.abs

fun main() {

}

private fun makeGood(s: String): String {
    val queue = Stack<Char>()
    for (c in s) {
        if (queue.isEmpty()) {
            queue.push(c)
            continue
        }
        if (abs(queue.peek() - c) == 32) {
            queue.pop()
        } else {
            queue.push(c)
        }
    }
    return queue.joinToString("")
}