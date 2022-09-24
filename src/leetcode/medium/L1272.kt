package leetcode.medium


fun main() {
    println(removeInterval(arrayOf(intArrayOf(0, 2), intArrayOf(3, 4), intArrayOf(5, 7)), intArrayOf(1, 6)))
    println(removeInterval(arrayOf(intArrayOf(0, 5)), intArrayOf(2, 3)))
    println(
        removeInterval(
            arrayOf(
                intArrayOf(-5, -4),
                intArrayOf(-3, -2),
                intArrayOf(1, 2),
                intArrayOf(3, 5),
                intArrayOf(8, 9)
            ), intArrayOf(-1, 4)
        )
    )
}

// 21:30 ~
private fun removeInterval(intervals: Array<IntArray>, toBeRemoved: IntArray): List<List<Int>> {
    val answer = mutableListOf<List<Int>>()
    val (removeStart, removeEnd) = toBeRemoved
    for ((start, end) in intervals) {
        if (removeStart <= start && end <= toBeRemoved[1]) {
            continue
        }
        when {
            start < removeStart && removeEnd < end -> {
                answer.add(listOf(start, removeStart))
                answer.add(listOf(removeEnd, end))
            }
            start < removeStart && removeStart < end -> {
                answer.add(listOf(start, removeStart))
            }
            start < removeEnd && removeEnd < end -> {
                answer.add(listOf(removeEnd, end))
            }
            else -> answer.add(listOf(start, end))
        }
    }
    return answer
}
