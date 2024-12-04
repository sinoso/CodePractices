package leetcode.easy

import tools.checkResult

fun main() {
    checkResult(expected = 0, strStr(haystack = "a", needle = "a"))
    checkResult(expected = 2, strStr(haystack = "hello", needle = "ll"))
    checkResult(expected = 0, strStr(haystack = "sadbutsad", needle = "sad"))
    checkResult(expected = -1, strStr(haystack = "leetcode", needle = "leeto"))
}

private fun strStr(haystack: String, needle: String): Int {
    if (haystack.length < needle.length)
        return -1
    var index = 0
    val lastIndex = haystack.length - needle.length
    while (index <= lastIndex) {
        var j = 0
        while (j <= needle.lastIndex) {
            if (haystack[index + j] != needle[j])
                break
            j++
        }
        if (j > needle.lastIndex)
            return index
        index++
    }
    return -1
}

