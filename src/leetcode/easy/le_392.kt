package leetcode.easy

import printResult

fun main() {
    printResult(isSubsequence(s = "abc", t = "ahbgdc"), true)
    printResult(isSubsequence(s = "axc", t = "ahbgdc"), false)
    printResult(isSubsequence(s = "a", t = "c"), false)
    printResult(isSubsequence(s = "aaaaaa", t = "bbaaaa"), false)
}

private fun isSubsequence(s: String, t: String): Boolean {
    var idx = 0
    var tIdx = 0
    var count = 0
    while (idx < s.length && tIdx < t.length) {
        while (tIdx < t.length)
            if (s[idx] == t[tIdx++]) {
                count++
                break
            }
        idx++
        if (tIdx == t.length)
            break
    }
    return count == s.length
}
