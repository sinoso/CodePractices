package leetcode.easy

import printResult


fun main() {
    printResult(
        diagonalSum(
            arrayOf(
                intArrayOf(1, 1, 1, 1),
                intArrayOf(1, 1, 1, 1),
                intArrayOf(1, 1, 1, 1),
                intArrayOf(1, 1, 1, 1)
            )
        ), 8
    )
    printResult(diagonalSum(arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))), 25)
    printResult(diagonalSum(arrayOf(intArrayOf(1, 2), intArrayOf(1, 2))), 6)
    printResult(diagonalSum(arrayOf(intArrayOf(1))), 1)
}

private fun diagonalSum(mat: Array<IntArray>): Int {
    var answer = 0
    var posModifier = 0
    val lastIndex = mat.lastIndex
    val size = mat.size
    for (array in mat)
        answer += array[posModifier] + array[lastIndex - posModifier++]
    if (mat.size and 1 == 1)
        answer -= mat[size / 2][size / 2]
    return answer
}
