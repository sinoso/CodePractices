package leetcode.easy

import tools.checkResult
import java.util.PriorityQueue

fun main() {
    checkResult(expected = 2, actual = secondHighest("dfa12321afd"))
    checkResult(expected = -1, actual = secondHighest("abc1111"))
}

private fun secondHighest(s: String): Int {
    val digitRange = '0'..'9'
    val queue = PriorityQueue<Char>()
    for (c in s) {
        if (c in digitRange) {
            if (!queue.contains(c))
                queue.offer(c)
        }
        while (queue.size > 2) {
            queue.poll()
        }
    }
    return queue.reversed().getOrNull(1)?.digitToInt() ?: -1
}