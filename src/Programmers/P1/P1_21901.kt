package Programmers

fun main() {
    println(solution(5, 24))
}

private fun solution(a: Int, b: Int): String {
    var daysInMonth = intArrayOf(0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30)
    var days = b
    for (i in 0 until a)
        days += daysInMonth[i]
    return when (days % 7) {
        1 -> "FRI"
        2 -> "SAT"
        3 -> "SUN"
        4 -> "MON"
        5 -> "TUE"
        6 -> "WED"
        else -> "THU"
    }
}