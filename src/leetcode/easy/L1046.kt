package leetcode.easy

import printResult
import java.util.*

fun main() {
    printResult(lastStoneWeight(intArrayOf(2, 7, 4, 1, 8, 1)), 1)
    printResult(lastStoneWeight(intArrayOf(1)), 1)
    printResult(lastStoneWeight(intArrayOf(1, 1)), 0)
}

private fun lastStoneWeight(stones: IntArray): Int {
    val heap = PriorityQueue<Int>(Collections.reverseOrder())
    for (i in stones)
        heap.add(i)
    while (heap.size > 1) {
        val result = heap.poll() - heap.poll()
        if (result > 0)
            heap.add(result)
    }
    return heap.poll() ?: 0
}
