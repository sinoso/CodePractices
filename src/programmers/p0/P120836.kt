package programmers.p0

import printResult

fun main() {
    printResult(solution(6), 4)
    printResult(solution(9), 3)
}

private fun solution(n: Int): Int = Math.sqrt(n.toDouble())
    .let { root -> (1..root.toInt()).count { n % it == 0 } * 2 - if (root == root.toInt().toDouble()) 1 else 0 }

private fun solution2(n: Int): Int {
    val root = Math.sqrt(n.toDouble())
    var answer = (1..root.toInt()).count { n % it == 0 } * 2
    if (root == root.toInt().toDouble())
        answer--
    return answer
}
