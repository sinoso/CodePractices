package leetcode.easy

fun main() {
    numRookCaptures(
        arrayOf(
            charArrayOf('.', '.', '.', '.', '.', '.', '.'),
            charArrayOf('.', '.', '.', 'p', '.', '.', '.'),
            charArrayOf('.', '.', '.', 'R', '.', '.', 'p'),
            charArrayOf('.', '.', '.', '.', '.', '.', '.'),
            charArrayOf('.', '.', '.', '.', '.', '.', '.'),
            charArrayOf('.', '.', '.', '.', '.', '.', '.'),
            charArrayOf('.', '.', '.', '.', '.', '.', '.'),
            charArrayOf('.', '.', '.', '.', '.', '.', '.'),
            charArrayOf('.', '.', '.', 'p', '.', '.', '.'),
            charArrayOf('.', '.', '.', '.', '.', '.', '.'),
            charArrayOf('.', '.', '.', '.', '.', '.', '.')
        )
    )
//    numRookCaptures(
//        arrayOf(
//            charArrayOf('.', '.', '.', '.', '.', '.', '.'),
//            charArrayOf('.', 'p', 'p', 'p', 'p', 'p', '.', '.'),
//            charArrayOf('.', 'p', 'p', 'B', 'p', 'p', '.', '.'),
//            charArrayOf('.', 'p', 'B', 'R', 'B', 'p', '.', '.'),
//            charArrayOf('.', 'p', 'B', 'p', 'p', '.', '.'),
//            charArrayOf('.', 'p', 'p', 'B', 'p', 'p', '.', '.'),
//            charArrayOf('.', 'p', 'p', 'B', 'p', 'p', '.', '.'),
//            charArrayOf('.', 'p', 'p', 'p', 'p', 'p', '.', '.'),
//            charArrayOf('.', 'p', 'p', 'p', 'p', 'p', '.', '.'),
//            charArrayOf('.', '.', '.', '.', '.', '.', '.', '.'),
//            charArrayOf('.', '.', '.', '.', '.', '.', '.')
//        )
//    )
}

private fun numRookCaptures(board: Array<CharArray>): Int {
    val y = board.indexOfFirst { it.contains('R') }
    val x = board[y].indexOfFirst { it == 'R' }
    var currentX = x
    var currentY = y
    var count = 0

    currentX--
    while (currentX >= 0) {
        if (board[y][currentX] != '.') {
            if (board[y][currentX] == 'p') {
                count++
            }
            break
        }
        currentX--
    }
    currentX = x
    currentX++
    while (currentX <= board.lastIndex) {
        if (board[y][currentX] != '.') {
            if (board[y][currentX] == 'p') {
                count++
            }
            break
        }
        currentX++
    }
    currentY--
    while (currentY >= 0) {
        if (board[currentY][x] != '.') {
            if (board[currentY][x] == 'p') {
                count++
            }
            break
        }
        currentY--
    }
    currentY = y
    currentY++
    while (currentY <= board.lastIndex) {
        if (board[currentY][x] != '.') {
            if (board[currentY][x] == 'p') {
                count++
            }
            break
        }
        currentY++
    }
    return count
}