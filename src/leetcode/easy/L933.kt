package leetcode.easy

import java.util.LinkedList
import java.util.Queue

fun main() {

}

class RecentCounter() {
    val queue: Queue<Int> = LinkedList()
    fun ping(t: Int): Int {
        queue.offer(t)
        val limit = (t - 3000)
        while (queue.peek() < limit) {
            queue.poll()
        }
        return queue.size
    }
}
