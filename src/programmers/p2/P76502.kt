package programmers.p2

import printResult
import java.util.*

fun main() {
    printResult(solution("[](){}"), 3)
    printResult(solution("}]()[{"), 2)
    printResult(solution("[)(]"), 0)
    printResult(solution("}}}"), 0)
    printResult(solution("}}}}"), 0)
    printResult(solution("[(])"), 0)
}

// 23:50 ~ 00:23
private fun solution(s: String): Int {
    if (s.length and 1 == 1)
        return 0
    val sb = StringBuilder(s)
    var answer = 0
    repeat(s.length) {
        sb.append(sb[0])
        sb.deleteAt(0)
        val stack = Stack<Char>()
        for (c in sb) {
            when (c) {
                '[', '(', '{' -> stack.push(c)
                ']' -> if (stack.isEmpty() || stack.pop() != '[') return@repeat
                '}' -> if (stack.isEmpty() || stack.pop() != '{') return@repeat
                ')' -> if (stack.isEmpty() || stack.pop() != '(') return@repeat
            }
        }
        if (stack.isEmpty())
            answer++
    }
    return answer
}

private fun solutionFail(s: String): Int { // can't work with [(])
    val sb = StringBuilder(s)
    var answer = 0
    repeat(s.length) {
        var sCount = 0
        var mCount = 0
        var lCount = 0
        sb.append(sb[0])
        sb.deleteAt(0)
        for (c in sb) {
            when (c) {
                '[' -> lCount++
                ']' -> if (lCount-- < 1) break

                '{' -> mCount++
                '}' -> if (mCount-- < 1) break

                '(' -> sCount++
                ')' -> if (sCount-- < 1) break
            }
        }
        if (lCount == 0 && mCount == 0 && sCount == 0)
            answer++
    }
    return answer
}
