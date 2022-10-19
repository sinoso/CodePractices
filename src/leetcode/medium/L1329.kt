package leetcode.medium

import java.util.*

fun main() {
    diagonalSort(arrayOf(intArrayOf(3, 3, 1, 1), intArrayOf(2, 2, 1, 2), intArrayOf(1, 1, 1, 2)))
}

private fun diagonalSort(mat: Array<IntArray>): Array<IntArray> {
    val queue = PriorityQueue<Int>(compareBy { it })
    val height = mat.size
    val width = mat.first().size
    fun diagonalWork(I: Int, J: Int, work: (h: Int, w: Int) -> Unit) {
        var i = I
        var j = J
        while (i < height && j < width)
            work(i++, j++)
    }
    for (i in 1 until height) {
        diagonalWork(i, 0) { h, w -> queue.offer(mat[h][w]) }
        diagonalWork(i, 0) { h, w -> mat[h][w] = queue.poll() }
    }
    for (j in 0 until width) {
        diagonalWork(0, j) { h, w -> queue.offer(mat[h][w]) }
        diagonalWork(0, j) { h, w -> mat[h][w] = queue.poll() }
    }
    return mat
}
