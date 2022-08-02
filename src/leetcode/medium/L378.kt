package leetcode.medium

import printResult
import java.util.*


fun main() {
    printResult(kthSmallest(arrayOf(intArrayOf(1, 5, 9), intArrayOf(10, 11, 13), intArrayOf(12, 13, 15)), 8), 13)

}

private fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
    val heap = PriorityQueue<Int>(compareBy { it })
    matrix.forEach {
        it.forEach{value->
            heap.add(value)
        }
    }
    repeat(k - 1) {
        heap.poll()
    }
    return heap.poll()
}
