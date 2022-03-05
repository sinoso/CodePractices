package leetcode.medium

import printResult

fun main() {
    printResult(champagneTower(25, 6, 1), 0.18750)
}

private fun champagneTower(poured: Int, query_row: Int, query_glass: Int): Double {
    if (poured == 0)
        return 0.0
    val glassArray = Array(query_row + 1) { Array(it + 1) { 0.0 } }
    glassArray[0][0] = poured.toDouble()
    for (i in 0 until glassArray.lastIndex) {
        for (j in glassArray[i].indices) {
            if (glassArray[i][j] > 1.0) {
                val flood = (glassArray[i][j] - 1) / 2
                glassArray[i + 1][j] += flood
                glassArray[i + 1][j + 1] += flood
            }
        }
    }
    return glassArray[query_row][query_glass].coerceAtMost(1.0)
}
