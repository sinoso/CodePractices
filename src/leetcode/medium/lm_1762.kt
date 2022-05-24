package leetcode.medium

import printResult
import java.util.*

fun main() {
    printResult(findBuildings(intArrayOf(4, 2, 3, 1)), intArrayOf(0, 2, 3))
}

fun findBuildings(heights: IntArray): IntArray {
    var max = 0
    val answerList = LinkedList<Int>()
    for (i in heights.indices.reversed()) {
        if (heights[i] > max) {
            answerList.add(0, i)
            max = heights[i]
        }
    }
    return answerList.toIntArray()
}
