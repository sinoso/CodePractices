package leetcode.medium

import printResult

fun main() {
    printResult(minOperations("110"), intArrayOf(1, 1, 3))
}


private fun minOperations(boxes: String): IntArray {
    return IntArray(boxes.length) { idx ->
        var current = 0
        var i = 0
        while (i < idx) {
            if (boxes[i] == '1')
                current += idx - i
            i++
        }
        while (i < boxes.length) {
            if (boxes[i] == '1')
                current += i - idx
            i++
        }
        current
    }
}

private fun minOperations2(boxes: String): IntArray {
    val answer = IntArray(boxes.length)
    for(idx in answer.indices){
        var current = 0
        var i = 0
        while (i < idx) {
            if (boxes[i] == '1')
                current += idx - i
            i++
        }
        while (i < boxes.length) {
            if (boxes[i] == '1')
                current += i - idx
            i++
        }
        answer[idx] = current
    }
    return answer
}


private fun minOperations3(boxes: String): IntArray {
    return IntArray(boxes.length) { idx ->
        var current = 0
        (0 until idx).forEach {
            if (boxes[it] == '1')
                current += idx - it
        }
        ((idx + 1)..boxes.lastIndex).forEach {
            if (boxes[it] == '1')
                current += it - idx
        }
        current
    }
}

private fun minOperations4(boxes: String): IntArray {
    val answer = IntArray(boxes.length) {
        var current = 0
        for (i in it..boxes.lastIndex) {
            if (boxes[i] == '1')
                current += i - it
        }
        for (i in 0 until it) {
            if (boxes[i] == '1')
                current += it - i
        }
        current
    }
    return answer
}

private fun minOperations5(boxes: String): IntArray =
    IntArray(boxes.length) { idx ->
        boxes.indices
            .asSequence()
            .filter { boxes[it] == '1' }
            .fold(0) { acc, i -> acc + if (i < idx) idx - i else i - idx }
    }
