package leetcode.medium

import printResult

fun main() {
    val array = arrayOf(
        intArrayOf(0, 1, 0),
        intArrayOf(0, 0, 1),
        intArrayOf(1, 1, 1),
        intArrayOf(0, 0, 0))
    gameOfLife(array)
    printResult(
        array,
        arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(1, 0, 1),
            intArrayOf(0, 1, 1),
            intArrayOf(0, 1, 0))
    )
    val array2 = arrayOf(
        intArrayOf(1, 0, 0, 0, 0, 1),
        intArrayOf(0, 0, 0, 1, 1, 0),
        intArrayOf(1, 0, 1, 0, 1, 0))
    gameOfLife(array2)
}

private fun gameOfLife(board: Array<IntArray>): Unit {
    val maxCol = board.size - 1
    val maxRow = board[0].size - 1
    for (i in 0..maxCol)
        for (j in 0..maxRow) {
            var numberOfCells = numberOfNearCells(i, j, maxRow, maxCol, board)
            if (numberOfCells == 0)
                numberOfCells = 4
            board[i][j] = numberOfCells * if (board[i][j] == 0) -1 else 1
        }
    for (i in 0..maxCol)
        for (j in 0..maxRow)
            board[i][j] = when (board[i][j]) {
                -2 -> 0
                2 -> 1
                3 -> 1
                -3 -> 1
                else -> 0
            }
}


private fun numberOfNearCells(i: Int, j: Int, maxRow: Int, maxCol: Int, board: Array<IntArray>): Int {
    val colRange = IntRange(if (i == 0) i else i - 1, if (i == maxCol) i else i + 1)
    val rowRange = IntRange(if (j == 0) j else j - 1, if (j == maxRow) j else j + 1)
    var count = 0
    for (row in rowRange)
        for (col in colRange)
            if (board[col][row] > 0)
                count++
    return count - board[i][j]
}

//Any live cell with fewer than two live neighbors dies as if caused by under-population. // 1개 이하면 dead cell
//Any live cell with two or three live neighbors lives on to the next generation. // live cell 일때는  2~3개 이면 삼
//Any live cell with more than three live neighbors dies, as if by over-population.  // 4개 이상이면 무조건 죽음
//Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction. // dead cell 일 때 3개면 삼
// summary
// <2 = dead cell
//  2 = no change
//  3 = live cell
// >3 =  dead cell

