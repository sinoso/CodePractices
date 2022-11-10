package programmers.p1

import printResult

fun main() {
    printResult(solution(3, 4, intArrayOf(1, 2, 3, 1, 2, 3, 1)), 8)

}

private fun solution(k: Int, m: Int, score: IntArray): Int {
    score.sortDescending()
    var answer = 0
    for (i in (m - 1)..score.lastIndex step m) {
        answer += score[i]
    }
    return answer * m
}

