package leetcode.easy

import tools.checkResult
import java.util.Collections
import java.util.PriorityQueue

fun main() {
    checkResult(expected = 29, pickGifts(gifts = intArrayOf(25, 64, 9, 4, 100), k = 4))
    checkResult(expected = 4, pickGifts(gifts = intArrayOf(1, 1, 1, 1), k = 4))
}

private fun pickGifts(gifts: IntArray, k: Int): Long {
    val queue = PriorityQueue<Int>(gifts.size, Collections.reverseOrder())
        .apply {
            for (i in gifts) {
                add(i)
            }
        }
    repeat(k) {
        queue.offer(Math.sqrt(queue.poll().toDouble()).toInt())
    }
    return queue.fold(0L) { acc, i -> acc + i }
}