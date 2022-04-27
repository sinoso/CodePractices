package leetcode.easy

import kotlin.math.absoluteValue

fun main() {

}

private fun minMovesToSeat(seats: IntArray, students: IntArray): Int {
    seats.sort()
    students.sort()
    var sum = 0
    for (index in seats.indices)
        sum += (seats[index] - students[index]).absoluteValue
    return sum
}

private fun minMovesToSeat2(seats: IntArray, students: IntArray): Int =
    seats.sorted()
        .zip(students.sorted())
        .map { it.first - it.second }
        .map { if (it < 0) it * -1 else it }
        .fold(0) { acc, i -> acc + i }

