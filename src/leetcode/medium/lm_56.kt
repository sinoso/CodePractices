package leetcode.medium

fun main() {
    println(merge(arrayOf(intArrayOf(1, 3),
        intArrayOf(2, 6),
        intArrayOf(8, 10),
        intArrayOf(15, 18))).joinToString(", ", "[", "]") { it.joinToString(", ", "[", "]") })
    println(merge(arrayOf(intArrayOf(1, 4),
        intArrayOf(1, 5))).joinToString(", ", "[", "]") { it.joinToString(", ", "[", "]") })
}

private fun merge(intervals: Array<IntArray>): Array<IntArray> {
    val answerList = mutableListOf<IntArray>()
    val sorted = intervals.sortedWith(compareBy<IntArray> { it[0] }.thenByDescending { it[1] })
    var current = sorted[0]
    for (i in sorted.indices) {
        if (current[1] >= sorted[i][1])
            continue
        if (current[1] >= sorted[i][0]) {
            current[1] = sorted[i][1]
            continue
        }
        answerList.add(current)
        current = sorted[i]
    }
    answerList.add(current)
    return answerList.toTypedArray()
}
