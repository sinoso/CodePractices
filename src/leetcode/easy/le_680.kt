package leetcode.easy

import printResult

fun main() {
    printResult(validPalindrome("aba"), true)
    printResult(validPalindrome("abca"), true)
    printResult(validPalindrome("abc"), false)
}

private fun validPalindrome(s: String, leftStart: Int = 0, rightStart: Int = s.lastIndex): Boolean {
    var left = leftStart
    var right = rightStart
    while (left < right) {
        if (s[left] != s[right])
            return if (leftStart == 0 && rightStart == s.lastIndex)
                validPalindrome(s, left + 1, right) || validPalindrome(s, left, right - 1)
            else
                false
        left++
        right--
    }
    return true
}

private fun validPalindrome2(s: String): Boolean {
    var left = 0
    var right = s.lastIndex
    while (left < right) {
        if (s[left] != s[right])
            return check(s, left + 1, right) || check(s, left, right - 1)
        left++
        right--
    }
    return true
}

private fun check(s: String, leftStart: Int, rightStart: Int): Boolean {
    var left = leftStart
    var right = rightStart
    while (left < right) {
        if (s[left] != s[right])
            return false
        left++
        right--
    }
    return true
}
