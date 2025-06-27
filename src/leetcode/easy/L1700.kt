package leetcode.easy

fun main() {

}

private fun countStudents(students: IntArray, sandwiches: IntArray): Int {
    val table = intArrayOf(0, 0)
    for (element in students) {
        table[element] += 1
    }
    var left = students.size
    for (i in sandwiches) {
        if (table[i] <= 0) {
            return left
        }
        table[i]--
        left--
    }
    return left
}

private fun countStudents2(students: IntArray, sandwiches: IntArray): Int {
    var countZero = students.count { it == 0 }
    var countOne = students.size - countZero
    var i = 0
    while (i < students.size) {
        if (sandwiches[i] == 0 && countZero > 0) {
            countZero--
        } else if (sandwiches[i] == 1 && countOne > 0) {
            countOne--
        } else {
            break
        }
        i++
    }
    return students.size - i
}

