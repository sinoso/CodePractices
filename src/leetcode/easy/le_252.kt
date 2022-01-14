package leetcode.easy

fun main() {
    println(canAttendMeetings(arrayOf(intArrayOf(0, 30), intArrayOf(5, 10), intArrayOf(15, 20))))
    println(canAttendMeetings(arrayOf(intArrayOf(7, 10), intArrayOf(2, 4))))
}

private fun canAttendMeetings(intervals: Array<IntArray>): Boolean {
    var lastValue = -1
    intervals.asSequence()
        .sortedWith(compareBy { it[0] })
        .forEach {
            if (lastValue > it[0])
                return false
            lastValue = it[1]
        }
    return true
}
