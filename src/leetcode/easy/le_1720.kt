package leetcode.easy

import printResult

fun main() {
    printResult(decode(intArrayOf(1, 2, 3), 1), intArrayOf(1, 0, 2, 1))
    printResult(decode(intArrayOf(6, 2, 7, 3), 4), intArrayOf(4, 2, 0, 7, 4))
}

private fun decode(encoded: IntArray, first: Int): IntArray {
    val answer = IntArray(encoded.size + 1).apply { this[0] = first }
    val answerSize = answer.size
    for (idx in 1 until answerSize)
        answer[idx] = answer[idx - 1] xor encoded[idx - 1]
    return answer
}

private fun decode2(encoded: IntArray, first: Int): IntArray {
    val answer = IntArray(encoded.size + 1).apply { this[0] = first }
    var idx = 1
    val answerSize = answer.size
    while (idx < answerSize) {
        answer[idx] = answer[idx - 1] xor encoded[idx - 1]
        idx++
    }
    return answer
}
