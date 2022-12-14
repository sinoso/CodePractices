package leetcode.medium

fun main() {

}

private fun minFallingPathSum(matrix: Array<IntArray>): Int {
    val widthLastIndex = matrix[0].lastIndex
    val heightLastIndex = matrix.lastIndex
    for (i in 1..heightLastIndex) {
        for (j in 0..widthLastIndex) {
            var min = matrix[i - 1][j]
            if (j > 0) {
                min = min.coerceAtMost(matrix[i - 1][j - 1])
            }
            if (j < widthLastIndex) {
                min = min.coerceAtMost(matrix[i - 1][j + 1])
            }
            matrix[i][j]+=min
        }
    }
    return matrix.last().reduce { acc, i -> acc.coerceAtMost(i) }
}
