package leetcode.medium

import printResult
import java.util.*


fun main() {
    printResult(furthestBuilding(intArrayOf(3, 100, 3, 5, 3, 5, 3), 0, 1), 2)
    printResult(furthestBuilding(intArrayOf(4, 2, 7, 6, 9, 14, 12), 5, 1), 4)
    printResult(furthestBuilding(intArrayOf(4, 12, 2, 7, 3, 18, 20, 3, 19), 10, 2), 7)
}

fun furthestBuilding(heights: IntArray, bricks: Int, ladders: Int): Int {
    var leftBricks = bricks
    val laddersQueue = PriorityQueue<Int>(compareBy { it })
    for (i in 0 until heights.lastIndex) {
        val diff = heights[i + 1] - heights[i]
        if (diff <= 0) {
            continue
        }
        laddersQueue.offer(diff)
        if (laddersQueue.size > ladders) {
            leftBricks -= laddersQueue.poll()
            if (leftBricks < 0)
                return i
        }
    }
    return heights.lastIndex
}
