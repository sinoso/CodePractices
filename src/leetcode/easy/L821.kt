package leetcode.easy

import java.util.*


fun main() {

}

private fun shortestToChar(s: String, c: Char): IntArray {
    val answer = IntArray(s.length)

    var preIndex = -10001
    for (i in s.indices) {
        if (s[i] == c) {
            preIndex = i
        }
        answer[i] = i - preIndex
    }
    preIndex = 10001
    for (i in s.indices.reversed()) {
        if (s[i] == c) {
            preIndex = i
        }
        answer[i] = answer[i].coerceAtMost(preIndex - i)
    }
    return answer
}
