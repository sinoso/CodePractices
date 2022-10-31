package programmers.p0

import printResult

fun main() {
    printResult(solution("3x + 7 + x"), "4x + 7")
    printResult(solution("x + x + x"), "3x")
//    printResult(solution(" "), "0")
    printResult(solution("1"), "1")
}

private fun solution(polynomial: String): String =
    polynomial.split(" + ")
        .groupBy({ it.last() == 'x' }) { if (it == "x") "1" else it }
        .let { map ->
            val a = map[true]?.let { it.fold(0) { acc, s -> acc + s.removeSuffix("x").toInt() } } ?: 0
            val b = map[false]?.let { it.fold(0) { acc, s -> acc + s.toInt() } } ?: 0
            val sb = StringBuilder()
            if (a > 1) {
                sb.append(a)
            }
            if (a >= 1) {
                sb.append('x')
            }
            if (a != 0 && b != 0) {
                sb.append(" + ")
            }
            if (b != 0) {
                sb.append(b)
            }
            sb.toString()
        }


