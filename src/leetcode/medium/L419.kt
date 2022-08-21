package leetcode.medium

import printResult

fun main() {
    printResult(wiggleMaxLength(intArrayOf(1, 7, 4, 9, 2, 5)), 6)
    printResult(wiggleMaxLength(intArrayOf(1, 1, 1, 1)), 1)
}

private fun countBattleships(board: Array<CharArray>): Int {
    var count = 0
    val maxHeight = board.lastIndex
    val maxWidth = board.first().lastIndex
    for (i in 0..maxHeight)
        for (j in 0..maxWidth) {
            if (board[i][j] == 'X' && (i == maxHeight || board[i + 1][j] == '.') && (j == maxWidth || board[i][j + 1] == '.'))
                count++
        }
    return count
}

private fun countBattleships2(board: Array<CharArray>): Int {
    val maxHeight = board.lastIndex
    val maxWidth = board.first().lastIndex
    fun check(board: Array<CharArray>, i: Int, j: Int): Boolean {
        if (board[i][j] != 'X')
            return false
        board[i][j] = '.'
        //top
        if (i != 0 && board[i - 1][j] != '.') {
            check(board, i - 1, j)
        }
        //left
        if (j != 0 && board[i][j - 1] != '.') {
            check(board, i, j - 1)
        }
        //bot
        if (i != maxHeight && board[i + 1][j] != '.') {
            check(board, i + 1, j)
        }
        //right
        if (j != maxWidth && board[i][j + 1] != '.') {
            check(board, i, j + 1)
        }
        return true
    }

    var count = 0

    for (i in 0..maxHeight)
        for (j in 0..maxWidth) {
            if (check(board, i, j))
                count++
        }
    return count
}


