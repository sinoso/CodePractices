package leetcode.medium

import printResult
import kotlin.text.StringBuilder

fun main() {
//    printResult(
//        numDistinctIslands(
//            arrayOf(
//                intArrayOf(1, 1, 0, 0, 0),
//                intArrayOf(1, 1, 0, 0, 0),
//                intArrayOf(0, 0, 0, 1, 1),
//                intArrayOf(0, 1, 0, 1, 1)
//            )
//        ), 1
//    )
    printResult(
        numDistinctIslands(
            arrayOf(
                intArrayOf(1,1,0),
                intArrayOf(0,1,1),
                intArrayOf(0,0,0),
                intArrayOf(1,1,1),
                intArrayOf(0,1,0)
            )
        ), 1
    )
//    printResult(
//        numDistinctIslands(arrayOf(intArrayOf(0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0), intArrayOf(0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0), intArrayOf(0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0), intArrayOf(1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1))
//        ), 15
//    )


}

private fun numDistinctIslands(grid: Array<IntArray>): Int {
    val set = HashSet<String>()
    val rowSize = grid.first().size
    val visitedArray = Array(grid.size) { BooleanArray(rowSize) }
    val rowRange = grid.first().indices
    for (col in grid.indices) {
        for (row in rowRange) {
            val result = checker(col, row, grid, visitedArray, direction = "S")
            if (result.isNotEmpty()) {
                set.add(result.toString())
            }
        }
    }
    return set.size
}

private fun checker(
    col: Int,
    row: Int,
    grid: Array<IntArray>,
    visitedArray: Array<BooleanArray>,
    sb: StringBuilder = StringBuilder(),
    direction: String
): StringBuilder {
    if (col < 0 || row < 0 || col >= visitedArray.size || row >= visitedArray[0].size || visitedArray[col][row]) {
        return sb
    }
    visitedArray[col][row] = true
    if (grid[col][row] == 0) {
        return sb
    }
    visitedArray[col][row] = true
    sb.append(direction)
    checker(col - 1, row, grid, visitedArray, sb, "D")
    checker(col + 1, row, grid, visitedArray, sb, "U")
    checker(col, row - 1, grid, visitedArray, sb, "L")
    checker(col, row + 1, grid, visitedArray, sb, "R")
    sb.append("E")
    return sb
}
