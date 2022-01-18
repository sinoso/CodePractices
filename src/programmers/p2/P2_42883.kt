package programmers.p2

import java.util.*

fun main() {
    println(solution("1924", 2))
    println(solution("1231234", 3))
    println(solution("4177252841", 4))
    println(solution("7751111", 4))
    println(solution("1", 1))
    println(solution("00000", 4))
}

private fun solution(number: String, k: Int): String {
    val stack = Stack<Char>()
    var count = 0
    for (char in number.toCharArray()) {
        while (stack.isNotEmpty() && stack.peek() < char && count < k) {
            stack.pop()
            count++
        }
        stack.push(char)
    }
    while (count < k) {
        stack.pop()
        count++
    }
    return buildString { stack.forEach { append(it) } }
}

private fun solution2(number: String, k: Int): String {
    val sb = StringBuilder().append(number)
    val stack = Stack<Int>()
    repeat(k) {
        val start = if (stack.isEmpty()) stack.push(0) else stack.peek()
        for (i in start + 1..sb.lastIndex) {
            if (sb[stack.peek()] < sb[i])
                break
            stack.push(i)
        }
        sb.deleteCharAt(stack.pop())
    }
    return sb.toString()
}

private fun solution3(number: String, k: Int): String {
    val sb = StringBuilder().append(number)
    repeat(k) {
        var min = 0
        for (idx in 1..sb.lastIndex) {
            if (sb[min] > sb[idx])
                min = idx
            if (sb[0] < sb[idx])
                break
        }
        sb.deleteCharAt(min)
    }
    return sb.toString()
}
