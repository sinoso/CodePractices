package leetcode.easy

import printResult

fun main() {
    printResult(calPoints(arrayOf("5", "2", "C", "D", "+")), 30)
    printResult(calPoints(arrayOf("5", "-2", "4", "C", "D", "9", "+", "+")), 27)
    printResult(calPoints(arrayOf("1")), 1)
    printResult(calPoints(arrayOf("5", "2", "C", "D", "+")), 30)
}

private fun calPoints(ops: Array<String>): Int =
    ops.fold(mutableListOf<Int>()) { pointList, s ->
        when (s) {
            "C" -> pointList.removeLast()
            "D" -> pointList.add(pointList.last() * 2)
            "+" -> pointList.add(pointList.takeLast(2).sum())
            else -> pointList.add(s.toInt())
        }
        pointList
    }.sum()

private fun calPointsForLeetCode(ops: Array<String>): Int =
    ops.fold(mutableListOf<Int>()) { pointList, s ->
        when (s) {
            "C" -> pointList.removeAt(pointList.lastIndex)
            "D" -> pointList.add(pointList.last() * 2)
            "+" -> pointList.add(pointList.takeLast(2).sumBy { it })
            else -> pointList.add(s.toInt())
        }
        pointList
    }.sumBy { it }


