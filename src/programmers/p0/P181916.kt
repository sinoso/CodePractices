package programmers.p0

import printResult

fun main() {
    printResult(solution(2, 2, 2, 2), 2222)
    printResult(solution(4, 1, 4, 4), 1681)
    printResult(solution(6, 3, 3, 6), 27)
    printResult(solution(2, 5, 2, 6), 30)
    printResult(solution(6, 4, 2, 5), 2)
    printResult(solution(5, 4, 6, 6), 20)
}

private fun solution(a: Int, b: Int, c: Int, d: Int): Int {
    val map = HashMap<Int, Int>().apply {
        put(a, (get(a) ?: 0) + 1)
        put(b, (get(b) ?: 0) + 1)
        put(c, (get(c) ?: 0) + 1)
        put(d, (get(d) ?: 0) + 1)
    }
    return when (map.size) {
        4 -> {
            map.entries.minByOrNull { it.value }!!.key
        }

        3 -> {
            val (p, q) = map.entries.sortedBy { it.value }.map { it.key }
            p * q
        }

        2 -> {
            val (p, q) = map.entries.sortedBy { it.value }
            if (p.value == 1) {
                (10 * q.key + p.key).let { it * it }
            } else {
                (p.key + q.key) * (p.key - q.key).let { if (it < 0) it * -1 else it }
            }
        }

        else -> {
            map.entries.first().key * 1111
        }
    }
}