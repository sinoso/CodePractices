package programmers

import printResult

fun main() {
    printResult(solution(2, 1, 20), 19)
}

private fun solution(a: Int, b: Int, n: Int): Int {
    var answer = 0
    var left = n
    while (left >= a) {
        val currentNew = left / a * b
        answer += currentNew
        left = currentNew + left % a
    }
    return answer
}
