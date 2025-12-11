package leetcode.medium

import kotlin.math.min

fun main() {
    countCoveredBuildings(
        3,
        arrayOf(intArrayOf(1, 2), intArrayOf(2, 2), intArrayOf(3, 2), intArrayOf(2, 1), intArrayOf(2, 3))
    )
}

private fun countCoveredBuildings(n: Int, buildings: Array<IntArray>): Int {
    var answer = 0
    val minOfRange = 0
    val maxOfRange = n
    val xMap = hashMapOf<Int, Pair<Int, Int>>() //x yMin yMax
    val yMap = hashMapOf<Int, Pair<Int, Int>>()//y xMin xMax
    for ((x, y) in buildings) {
        var yRangeByX = xMap[x] ?: (y to y)
        yRangeByX = minOf(yRangeByX.first, y) to maxOf(yRangeByX.second, y)
        xMap[x] = yRangeByX
        var xRangeByY = yMap[y] ?: (x to x)
        xRangeByY = minOf(xRangeByY.first, x) to maxOf(xRangeByY.second, x)
        yMap[y] = xRangeByY
    }
    for ((x, y) in buildings) {
        if (y > (xMap[x]?.first ?: maxOfRange) &&
            y < (xMap[x]?.second ?: minOfRange) &&
            x > (yMap[y]?.first ?: maxOfRange) &&
            x < (yMap[y]?.second ?: minOfRange)
        ) {
            answer++
        }
    }
    return answer
}

private fun countCoveredBuildings2(n: Int, buildings: Array<IntArray>): Int {
    var answer = 0
    val xMap = hashMapOf<Int, Pair<Int, Int>>() //x yMin yMax
    val yMap = hashMapOf<Int, Pair<Int, Int>>()//y xMin xMax
    for ((x, y) in buildings) {
        var yRangeInX = xMap[x] ?: (y to y)
        if (yRangeInX.first > y) {
            yRangeInX = yRangeInX.copy(first = y)
        }
        if (yRangeInX.second < y) {
            yRangeInX = yRangeInX.copy(second = y)
        }
        xMap[x] = yRangeInX


        var xRangeInY = yMap[y] ?: (x to x)
        if (xRangeInY.first > x) {
            xRangeInY = xRangeInY.copy(first = x)
        }
        if (xRangeInY.second < x) {
            xRangeInY = xRangeInY.copy(second = x)
        }
        yMap[y] = xRangeInY
    }
    for ((x, y) in buildings) {
        if (y > xMap[x]!!.first && y < xMap[x]!!.second && x > yMap[y]!!.first && x < yMap[y]!!.second) {
            answer++
        }
    }
    return answer
}