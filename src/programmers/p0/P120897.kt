package programmers.p0

import kotlin.math.sqrt

fun main() {
}

private fun solution(n: Int): IntArray =
    (1..sqrt(n.toDouble()).toInt())
        .filter { n % it == 0 }
        .fold(sortedSetOf<Int>()) { set, i ->
            set.apply {
                add(i)
                add(n / i)
            }
        }.toIntArray()
