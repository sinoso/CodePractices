package leetcode.medium

import printResult


fun main() {
    arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 1, 0), intArrayOf(0, 0, 0))

    printResult(uniquePathsWithObstacles(arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 1, 0), intArrayOf(0, 0, 0))), 2)
    printResult(uniquePathsWithObstacles(arrayOf(intArrayOf(0, 1), intArrayOf(0, 0))), 1)
}

private fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
    val rowSize = obstacleGrid.size
    val colSize = obstacleGrid[0].size
    val lastRow = rowSize - 1
    val lastCol = colSize - 1
    val grid = Array(rowSize) { IntArray(colSize) { 0 } }
        .apply {
            this[0][0] = 1
        }
    for (col in 0 until lastCol) {
        for (row in 0 until lastRow) {
            if (obstacleGrid[row][col] != 1) {
                grid[row + 1][col] += grid[row][col]
                grid[row][col + 1] += grid[row][col]
            }
        }
        if (obstacleGrid[lastRow][col] != 1) {
            grid[lastRow][col + 1] += grid[lastRow][col]
        }
    }
    for (row in 0 until lastRow) {
        if (obstacleGrid[row][lastCol] != 1) {
            grid[row + 1][lastCol] += grid[row][lastCol]
        }
    }
    return if (obstacleGrid[lastRow][lastCol] == 1) 0 else grid[lastRow][lastCol]
}
