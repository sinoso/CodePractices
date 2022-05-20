package leetcode.medium

import printResult


fun main() {
    printResult(uniquePaths(3, 7), 28)
    printResult(uniquePaths(3, 2), 3)
}

private fun uniquePaths(m: Int, n: Int): Int {
    val grid = Array(m) { IntArray(n) { 0 } }.apply {
        this[0][0] = 1
    }
    val lastRow = m - 1
    val lastCol = n - 1
    for (col in 0 until lastCol) {
        for (row in 0 until lastRow) {
            grid[row][col + 1] += grid[row][col]
            grid[row + 1][col] += grid[row][col]
        }
        grid[lastRow][col + 1] += grid[lastRow][col]
    }
    var sum =0
    for(i in 0..lastRow){
        sum+= grid[i][lastCol]
    }
    return sum
//    return (0..lastRow).sumOf { grid[it][lastCol] }
}
