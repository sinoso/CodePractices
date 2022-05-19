package leetcode.hard

import printResult


fun main() {
    val matrix = arrayOf(
        intArrayOf(9, 9, 4),
        intArrayOf(6, 6, 8),
        intArrayOf(2, 1, 1)
    )
    val matrix2 = arrayOf(
        intArrayOf(3, 4, 5),
        intArrayOf(3, 2, 6),
        intArrayOf(2, 2, 1)
    )
    printResult(longestIncreasingPath(matrix), 4)
    printResult(longestIncreasingPath(matrix2), 4)
    printResult(longestIncreasingPath(arrayOf(intArrayOf(1))), 1)
    printResult(longestIncreasingPath(arrayOf(intArrayOf(1, 2))), 2)
    printResult(longestIncreasingPath(
        arrayOf(
            intArrayOf(7, 7, 5),
            intArrayOf(2, 4, 6),
            intArrayOf(8, 2, 0)
        )
    ), 4)
}

lateinit var matrixIn: Array<IntArray>
lateinit var longestPath: Array<IntArray>
var max = 0
fun longestIncreasingPath(matrix: Array<IntArray>): Int {
    val colLastIndex = matrix[0].lastIndex
    val colSize = matrix[0].size
    val rowSize = matrix.size
    val rowLastIndex = matrix.lastIndex
    matrixIn = matrix
    longestPath = Array(rowSize) { IntArray(colSize) { 1 } }
    val slotList = mutableListOf<Pair<Int, Int>>().apply {
        for (i in 0..rowLastIndex)
            for (j in 0..colLastIndex)
                add(Pair(i, j))
    }.sortedBy { matrix[it.first][it.second] }

    slotList.forEach {
        changeNearValue(rowLastIndex, colLastIndex, it.first, it.second)
    }
    return max
}

private fun changeNearValue(rowLastIndex: Int, colLastIndex: Int, row: Int, col: Int) {
    max = max.coerceAtLeast(longestPath[row][col])
    val currentValue = matrixIn[row][col]
    val currentPathLength = longestPath[row][col] + 1
    fun checkAndSet(row: Int, col: Int) {
        if (matrixIn[row][col] > currentValue)
            if (longestPath[row][col] < currentPathLength)
                longestPath[row][col] = currentPathLength
    }
    if (col < colLastIndex)
        checkAndSet(row, col + 1)
    if (col > 0)
        checkAndSet(row, col - 1)
    if (row < rowLastIndex)
        checkAndSet(row + 1, col)
    if (row > 0)
        checkAndSet(row - 1, col)
}
