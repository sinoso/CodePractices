package leetcode.medium

import printResult
import java.lang.StringBuilder

fun main() {
    printResult(minRemoveToMakeValid("lee(t(c)o)de)"), "lee(t(c)o)de")
    printResult(minRemoveToMakeValid("a)b(c)d"), "ab(c)d")
    printResult(minRemoveToMakeValid("))(("), "")
    printResult(minRemoveToMakeValid("())()((("), "()()")

}


private fun minRemoveToMakeValid(s: String): String {
    fun refine(string: CharSequence, open: Char, close: Char): StringBuilder {
        val sb = StringBuilder()
        var count = 0
        for (ch in string) {
            when (ch) {
                open -> {
                    sb.append(ch)
                    count++
                }
                close ->
                    if (count > 0) {
                        sb.append(ch)
                        count--
                    }
                else -> sb.append(ch)
            }
        }
        return sb
    }
    return refine(refine(s, '(', ')').reverse(), ')', '(').reverse().toString()
}

private fun minRemoveToMakeValid2(s: String): String {
    val sb = StringBuilder()
    var count = 0
    for (ch in s) {
        if (ch == '(') {
            sb.append(ch)
            count++
        } else if (ch == ')') {
            if (count > 0) {
                sb.append(ch)
                count--
            }
        } else {
            sb.append(ch)
        }
    }
    val refined = sb.reversed()
    count = 0
    sb.setLength(0)
    for (ch in refined) {
        if (ch == ')') {
            sb.append(ch)
            count++
        } else if (ch == '(') {
            if (count > 0) {
                sb.append(ch)
                count--
            }
        } else {
            sb.append(ch)
        }
    }
    return sb.reverse().toString()
}
