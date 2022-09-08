package leetcode.medium

import java.util.*

fun main() {

}

//01:03 ~ 01:17
class HitCounter() {
    private val queue: Queue<Int> = LinkedList()

    fun hit(timestamp: Int) {
        queue.add(timestamp)
    }

    fun getHits(timestamp: Int): Int {
        val currentLimit = timestamp - 300
        while (queue.isNotEmpty() && queue.peek() <= currentLimit) {
            queue.poll()
        }
        return queue.size
    }

}
