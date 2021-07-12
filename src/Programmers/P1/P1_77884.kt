package Programmers

import kotlin.math.sqrt

fun main() {
    println(solution(13, 17))
}

private fun solution(left: Int, right: Int): Int {

    return (left..right)
            .map { v -> if (sqrt(v.toDouble()) % 1 == 0.0) v * -1 else v }
            .reduce { a, b -> a + b }
}