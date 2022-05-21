package leetcode.medium

fun main() {
    maxIncreaseKeepingSkyline(
        arrayOf(intArrayOf(8, 4, 8, 7),
    intArrayOf(7, 4, 7, 7),
    intArrayOf(9, 4, 8, 7),
    intArrayOf(3, 3, 3, 3))
    )
}

private fun maxIncreaseKeepingSkyline(grid: Array<IntArray>): Int {
    val size = grid.size
    val rowMaximumValues = IntArray(size) { grid[it].fold(0){i, acc ->  acc.coerceAtLeast(i)} }
    val colMaximumValues = IntArray(size) {
        var max = 0
        for (i in 0 until size)
            max = max.coerceAtLeast(grid[i][it])
        max
    }
    var answer = 0
    fun ableMaxValue(row: Int, col: Int) = rowMaximumValues[row].coerceAtMost(colMaximumValues[col])
    for (row in 0 until size) {
        for (col in 0 until size) {
            answer += ableMaxValue(row, col) - grid[row][col]
        }
    }
    return answer
}
