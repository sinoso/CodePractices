package Programmers

fun main() {
    println(solution(
            arrayOf(intArrayOf(0, 0, 0, 0, 0),
                    intArrayOf(0, 0, 1, 0, 3),
                    intArrayOf(0, 2, 5, 0, 1),
                    intArrayOf(4, 2, 4, 4, 2),
                    intArrayOf(3, 5, 1, 3, 1)),
            intArrayOf(1, 5, 3, 5, 1, 2, 1, 4)))
}

private fun solution(board: Array<IntArray>, moves: IntArray): Int {
    var basket = ArrayList<Int>()
    var answer = 0
    for (move in moves) {
        for (col in board.indices) {
            if (board[col][move-1] != 0) {
                basket.add(board[col][move-1])
                if (basket.size > 1) {
                    if (basket[basket.lastIndex] == basket[basket.lastIndex - 1]){
                        answer++
                        basket.removeAt(basket.lastIndex)
                        basket.removeAt(basket.lastIndex)
                    }
                }
                board[col][move-1] = 0
                break
            }
        }
    }
    return answer * 2
}