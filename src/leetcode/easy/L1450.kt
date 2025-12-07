package leetcode.easy

fun main() {
}

private fun busyStudent(startTime: IntArray, endTime: IntArray, queryTime: Int): Int =
    startTime.zip(endTime).count { (first, second) -> queryTime in first..second }