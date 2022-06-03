package leetcode.medium


fun main() {

}

class NumMatrix(val matrix: Array<IntArray>) {
    init {
        val rowRange = 1..matrix.lastIndex
        val colRange = matrix.first().indices
        for (i in rowRange)
            for (j in colRange) {
                matrix[i][j] += matrix[i - 1][j]
            }
    }

    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        var sum = 0
        if (row1 > 0)
            for (i in col1..col2) {
                sum -= matrix[row1 - 1][i]
            }
        for (i in col1..col2) {
            sum += matrix[row2][i]
        }
        return sum
    }
}
