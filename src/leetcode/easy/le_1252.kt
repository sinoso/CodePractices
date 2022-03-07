package leetcode.easy

import printResult

fun main() {
    printResult(oddCells(m = 2, n = 3, indices = arrayOf(intArrayOf(0, 1), intArrayOf(1, 1))), 6)
}

private fun oddCells(m: Int, n: Int, indices: Array<IntArray>): Int {
    val array = Array(m) { IntArray(n) }
    var idx: Int
    for ((i, j) in indices) {
        idx = 0
        while (idx < n)
            array[i][idx++]++
        idx = 0
        while (idx < m)
            array[idx++][j]++
    }
    var answer = 0
    var i = 0
    var j: Int
    while (i < m) {
        j = 0
        while (j < n) {
            if (array[i][j] and 1 == 1)
                answer++
            j++
        }
        i++
    }
    return answer
}

private fun oddCells2(m: Int, n: Int, indices: Array<IntArray>): Int {
    val array = Array(m) { IntArray(n) }
    for ((i, j) in indices) {
        for (idx in 0 until n)
            array[i][idx]++
        for (idx in 0 until m)
            array[idx][j]++
    }
    var answer = 0
    for (i in 0 until m)
        for (j in 0 until n)
            if (array[i][j] and 1 == 1)
                answer++
    return answer
}
