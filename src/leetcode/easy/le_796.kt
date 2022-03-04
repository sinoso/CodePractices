package leetcode.easy

import printResult

fun main() {
    printResult(rotateString(s = "xjab", goal = "abcd"), false)
    printResult(rotateString(s = "abcde", goal = "cdeab"), true)
    printResult(rotateString(s = "abcde", goal = "abced"), false)
    printResult(rotateString(s = "ffufrwpiddgyynfujnqblngzoogzg", goal = "fufrwpiddgyynfujnqblngzoogzgf"), true)
}

private fun rotateString(s: String, goal: String): Boolean {
    val length = s.length
    if (length != goal.length)
        return false
    var i = 0
    while (i < length) {
        if (s[i] == goal[0]) {
            var j = 0
            var k = i
            while (k < length) {
                if (goal[j] != s[k])
                    break
                j++
                k++
            }
            i = k
            if (k != length)
                continue
            k = 0
            while (j < length) {
                if (goal[j] != s[k])
                    break
                j++
                k++
            }
            if (j != length)
                continue
            return true
        }
        i++
    }
    if (i == length)
        return false
    return true
}

private fun rotateString2(s: String, goal: String): Boolean
= s.length == goal.length && (s + s).contains(goal)

