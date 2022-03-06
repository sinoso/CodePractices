package leetcode.medium

import printResult

fun main() {
    val array1 = arrayOf(
        intArrayOf(0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
        intArrayOf(0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0),
        intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0),
        intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0)
    )
    printResult(maxAreaOfIsland(array1), 6)
}

private fun maxAreaOfIsland(grid: Array<IntArray>): Int {
    var max = 0
    var i = 0
    var j: Int
    val rowMax = grid.lastIndex
    val colMax = grid[0].lastIndex
    while (i <= rowMax) {
        j = 0
        while (j <= colMax) {
            if (grid[i][j] == 1)
                max = max.coerceAtLeast(search(grid, i, j, rowMax, colMax))
            j++
        }
        i++
    }
    return max
}

private fun search(grid: Array<IntArray>, i: Int, j: Int, rowMax: Int, colMax: Int): Int {
    if (i < 0 || i >= rowMax || j < 0 || j >= colMax||grid[i][j] != 1) return 0
    grid[i][j] = 0
    var answer = 1
    answer += search(grid, i - 1, j, rowMax, colMax)
    answer += search(grid, i + 1, j, rowMax, colMax)
    answer += search(grid, i, j - 1, rowMax, colMax)
    answer += search(grid, i, j + 1, rowMax, colMax)
    return answer
}

private fun search2(grid: Array<IntArray>, i: Int, j: Int, rowMax: Int, colMax: Int): Int {
    if (grid[i][j] != 1)
        return 0
    grid[i][j] = 0
    var answer = 1
    if (i > 0)
        answer += search(grid, i - 1, j, rowMax, colMax)
    if (i < rowMax)
        answer += search(grid, i + 1, j, rowMax, colMax)
    if (j > 0)
        answer += search(grid, i, j - 1, rowMax, colMax)
    if (j < colMax)
        answer += search(grid, i, j + 1, rowMax, colMax)
    return answer
}
