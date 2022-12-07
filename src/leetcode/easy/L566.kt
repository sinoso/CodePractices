package leetcode.easy

fun main() {
    matrixReshape(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)), 1, 4)
    matrixReshape(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)), 2, 4)
    matrixReshape(arrayOf(intArrayOf(1, 2, 3, 4)), 2, 2)
}

private fun matrixReshape(mat: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
    val width = mat[0].size
    val height = mat.size
    var index = 0
    if (width * height != r * c)
        return mat
    val answer = Array(r) {
        IntArray(c) {
            mat[index / width][index++ % width]
        }
    }
    return answer
}