package leetcode.medium

import printResult

fun main() {
    printResult(findMinDifference(listOf("23:59", "00:00")), 1)
    printResult(findMinDifference(listOf("00:00", "23:59", "00:00")), 0)
}

private fun findMinDifference(timePoints: List<String>): Int {
    fun String.checkDiff(larger: String): Int {
        val hours = (larger[0] - this[0]) * 10 + (larger[1] - this[1])
        val mins = (larger[3] - this[3]) * 10 + (larger[4] - this[4])
        val answer = hours * 60 + mins
        if (answer > 720)
            return 1440 - answer
        return answer
    }

    val sorted = timePoints.sortedWith(compareBy<String> { it[0] }.thenBy { it[1] }.thenBy { it[3] }.thenBy { it[4] })
    var answer = sorted.first().checkDiff(sorted.last())
    var i = 0
    while (answer != 0 && i < sorted.lastIndex) {
        answer = answer.coerceAtMost(sorted[i].checkDiff(sorted[i + 1]))
        i++
    }
    return answer
}
