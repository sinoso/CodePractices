package programmers.p2

fun main() {
    println(solution(6, 6, arrayOf(intArrayOf(2, 2, 5, 4), intArrayOf(3, 3, 6, 6), intArrayOf(5, 1, 6, 3))).contentToString())//3,8
    println(solution(3, 3, arrayOf(intArrayOf(1, 1, 2, 2), intArrayOf(1, 2, 2, 3), intArrayOf(2, 1, 3, 2), intArrayOf(2, 2, 3, 3))).contentToString())//3,8
    println(solution(100, 97, arrayOf(intArrayOf(1, 1, 100, 97))).contentToString())//3,8
}

private fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
    val answer = IntArray(queries.size)
    val board = Array(rows * columns) { v -> v + 1 }
    for ((answerIdx, xys) in queries.withIndex()) {
        var width = xys[3] - xys[1] + 1
        var height = xys[2] - xys[0] + 1
        var currentX = xys[1] - 1
        var currentY = xys[0] - 1
        var currentValue: Int
        var tries = 2 * (width + height - 2)
        var firstValue = board[currentX + (currentY) * columns]
        var min = firstValue
        var accX: Int
        var accY: Int
        for (i in 0 until (tries - 1)) {
            when {
                i < height - 1 -> {
                    accX = 0
                    accY = 1
                }
                i < height + width - 2 -> {
                    accX = 1
                    accY = 0
                }
                i < 2 * height + width - 3 -> {
                    accX = 0
                    accY = -1
                }
                else -> {
                    accX = -1
                    accY = 0
                }
            }
            currentValue = board[(currentX + accX) + (currentY + accY) * (columns)]
            board[currentX + currentY * columns] = currentValue
            currentY += accY
            currentX += accX
            min = minOf(min, currentValue)
        }
        board[currentX + currentY * columns] = firstValue
        answer[answerIdx] = min
    }
    return answer
}