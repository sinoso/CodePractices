package leetcode.easy

fun main() {

}

private fun transpose(matrix: Array<IntArray>): Array<IntArray> {
    val rowSize = matrix.size
    val colSize = matrix.first().size
    return Array(colSize) { row -> IntArray(rowSize) { col -> matrix[col][row] } }
}
