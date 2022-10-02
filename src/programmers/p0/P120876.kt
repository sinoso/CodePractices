package programmers.p0

import printResult

fun main() {
    printResult(solution(arrayOf(intArrayOf(-99, -98), intArrayOf(-99, -97), intArrayOf(-98, -97))), 2)
}

private fun solution(lines: Array<IntArray>): Int {
    val table = ShortArray(200)
    val max = 2.toShort()
    lines.map { it.sorted() }.forEach { (a, b) ->
        val start = a.coerceAtMost(b)
        val end = a.coerceAtLeast(b)
        (start + 99 until end + 99).forEach {
            if (table[it] != max)
                table[it]++
        }
    }
    return table.count { it == max }
}

