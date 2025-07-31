package leetcode.easy

import java.util.PriorityQueue

fun main() {
    splitNum(4325)
}

private fun splitNum(num: Int): Int {
    var v1 = 0
    var v2 = 0
    var left = num
    val queue = PriorityQueue<Int>()
    while (left > 0) {
        queue.add(left % 10)
        left /= 10
    }
    while (queue.size > 0) {
        v1 *= 10
        v1 += queue.poll()
        if (queue.isNotEmpty()) {
            v2 *= 10
            v2 += queue.poll()
        }
    }
    return v1 + v2
}