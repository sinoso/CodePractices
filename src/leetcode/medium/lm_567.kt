package leetcode.medium

import printResult

fun main() {
    printResult(checkInclusion(s1 = "ab", s2 = "ba"), true)
    printResult(checkInclusion(s1 = "ab", s2 = "eidbaooo"), true)
    printResult(checkInclusion(s1 = "ab", s2 = "eidboaoo"), false)
    printResult(checkInclusion(s1 = "adc", s2 = "dcda"), true)
    printResult(checkInclusion(s1 = "ab", s2 = "a"), false)
    printResult(checkInclusion(s1 = "abcdxabcde", s2 = "abcdeabcdx"), true)
}

private fun checkInclusion(s1: String, s2: String): Boolean {
    if (s1.length > s2.length)
        return false
    val checkerArray = IntArray(123)
    val windowArray = IntArray(123)
    for (idx in s1.indices) {
        checkerArray[s1[idx].toInt()]++
        windowArray[s2[idx].toInt()]++
    }
    for (idx in s1.length until s2.length) {
        if (checkerArray isSame windowArray) return true
        windowArray[s2[idx].toInt()]++
        windowArray[s2[idx - s1.length].toInt()]--
    }
    return checkerArray isSame windowArray
}
infix fun IntArray.isSame(other:IntArray): Boolean {
    for (i in 97..122)
        if (this[i] != other[i])
            return false
    return true
}

private fun checkInclusion2(s1: String, s2: String): Boolean {
    if (s1.length > s2.length)
        return false
    val checkerMap = s1.groupingBy { it }.eachCount()
    val windowMap = HashMap<Char, Int>()
    for (idx in s1.indices)
        windowMap[s2[idx]] = windowMap.getOrDefault(s2[idx], 0) + 1
    for (idx in s1.length until s2.length) {
        if (windowMap == checkerMap)
            return true
        windowMap[s2[idx]] = windowMap.getOrDefault(s2[idx], 0) + 1
        val removeChar = s2[idx - s1.length]
        if (windowMap[removeChar]!! == 1) {
            windowMap.remove(removeChar)
            continue
        }
        windowMap[removeChar] = windowMap[removeChar]!! - 1
    }
    return windowMap == checkerMap
}
