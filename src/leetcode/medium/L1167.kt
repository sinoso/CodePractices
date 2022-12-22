package leetcode.medium

import java.util.*


fun main() {

}

private fun connectSticks(sticks: IntArray): Int {
    val queue = PriorityQueue<Int>(compareBy { it })
    var answer = 0
    sticks.forEach { queue.offer(it) }
    while (queue.size > 1) {
        val current = queue.poll() + queue.poll()
        answer+=current
        queue.offer(current)
    }
    return answer
}
