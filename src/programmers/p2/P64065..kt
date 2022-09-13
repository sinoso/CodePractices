package programmers.p2

import printResult

fun main() {
    printResult(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"), intArrayOf(2, 1, 3, 4))
}

// 19:36 ~ 20:00

private fun solution(s: String): IntArray =
    s.replace("{", "")
        .replace("}", "")
        .split(',')
        .fold(HashMap<String, Int>()) { acc, element ->
            acc[element] = (acc[element] ?: 0) + 1
            acc
        }.entries
        .sortedByDescending { it.value }
        .map { it.key.toInt() }
        .toIntArray()
