package Programmers

import kotlin.math.*

fun main() {
    println(solution(121))
    println(solution(3))
}

private fun solution(n: Long): Long {
    var value = sqrt(n.toDouble());
    return if (value - value.toLong().toDouble() == 0.toDouble())
        (value + 1).pow(2.0).toLong()
    else -1
}