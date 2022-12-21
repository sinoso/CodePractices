package programmers

import printResult

fun main() {

}

private fun solution(s: String): Int {
    var answer: Int = 0
    var current = 1
    var other = 0
    var char: Char? = null
    for (i in 0..s.lastIndex) {
        char ?: run { char = s[i] }
        if (s[i] == char) {
            current++
        } else {
            other++
        }
        if (current == other) {
            char = null
            answer++
            current = 0
            other = 0
        }
    }

    return answer + if (current != 0) 1 else 0
}
