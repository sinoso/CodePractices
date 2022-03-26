package leetcode.medium

fun main() {

}

private fun multiply(mat1: Array<IntArray>, mat2: Array<IntArray>): Array<IntArray> =
    Array(mat1.size) { i -> IntArray(mat2[0].size) { j -> mat1[i].foldIndexed(0) { index, acc, value -> acc + value * mat2[index][j] } } }

private fun multiply2(mat1: Array<IntArray>, mat2: Array<IntArray>): Array<IntArray> {
    val row = mat1.size
    val col = mat2[0].size
    val answer =
        Array(row) { i -> IntArray(col) { j -> mat1[i].foldIndexed(0) { index, acc, value -> acc + value * mat2[index][j] } } }
    return answer
}
