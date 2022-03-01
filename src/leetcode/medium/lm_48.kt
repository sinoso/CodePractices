package leetcode.medium

import tools.PrintArray

fun main() { //m40
    val array1 = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))
    rotate0(array1)
    PrintArray.printArray2(array1)

    val array2 =
        arrayOf(intArrayOf(5, 1, 9, 11), intArrayOf(2, 4, 8, 10), intArrayOf(13, 3, 6, 7), intArrayOf(15, 14, 12, 16))
    rotate0(array2)
    PrintArray.printArray2(array2)

}
//방법은?
// 0,0 -> 0,last
//0,last-> last,last
//last,last-> last,0
//last,0-> 0,0

private fun rotate0(matrix: Array<IntArray>): Unit {
    var first = 0
    var last = matrix.lastIndex
    while (first < last) {
        var pos = 0
        val limit = last - first
        while (pos < limit) {
            matrix[first][first + pos] = matrix[first][first + pos] xor matrix[first + pos][last]
            matrix[first + pos][last] = matrix[first][first + pos] xor matrix[first + pos][last]
            matrix[first][first + pos] = matrix[first][first + pos] xor matrix[first + pos][last]

            matrix[first][first + pos] = matrix[first][first + pos] xor matrix[last][last - pos]
            matrix[last][last - pos] = matrix[first][first + pos] xor matrix[last][last - pos]
            matrix[first][first + pos] = matrix[first][first + pos] xor matrix[last][last - pos]

            matrix[first][first + pos] = matrix[first][first + pos] xor matrix[last - pos][first]
            matrix[last - pos][first] = matrix[first][first + pos] xor matrix[last - pos][first]
            matrix[first][first + pos] = matrix[first][first + pos] xor matrix[last - pos][first]
            pos++
        }
        first++
        last--
    }
}
private fun rotate(matrix: Array<IntArray>): Unit {
    fun swap(i1: Int, j1: Int, i2: Int, j2: Int) {
        matrix[i1][j1] = matrix[i1][j1] xor matrix[i2][j2]
        matrix[i2][j2] = matrix[i1][j1] xor matrix[i2][j2]
        matrix[i1][j1] = matrix[i1][j1] xor matrix[i2][j2]
    }

    var first = 0
    var last = matrix.lastIndex
    while (first < last) {
        var pos = 0
        while (pos < (last - first)) {
            swap(first, first + pos, first + pos, last)
            swap(first, first + pos, last, last - pos)
            swap(first, first + pos, last - pos, first)
            pos++
        }
        first++
        last--
    }
}

private fun rotate2(matrix: Array<IntArray>): Unit {
    fun swap(i1: Int, j1: Int, i2: Int, j2: Int) {
        matrix[i1][j1] = matrix[i1][j1] xor matrix[i2][j2]
        matrix[i2][j2] = matrix[i1][j1] xor matrix[i2][j2]
        matrix[i1][j1] = matrix[i1][j1] xor matrix[i2][j2]
    }

    var first = 0
    var last = matrix.lastIndex
    while (first < last) {
        for (pos in 0 until last - first) {
            swap(first, first + pos, first + pos, last)
            swap(first, first + pos, last, last - pos)
            swap(first, first + pos, last - pos, first)
        }
        first++
        last--
    }
}

private fun rotate3(matrix: Array<IntArray>): Unit {
    var first = 0
    var last = matrix.lastIndex
    var temp: Int
    var pos: Int
    while (first < last) {
        pos = 0
        while (pos < (last - first)) {
            temp = matrix[first][first + pos]
            matrix[first][first + pos] = matrix[last - pos][first]
            matrix[last - pos][first] = matrix[last][last - pos]
            matrix[last][last - pos] = matrix[first + pos][last]
            matrix[first + pos][last] = temp
            pos++
        }
        first++
        last--
    }
}
