package leetcode.medium

import printResult

fun main() {
    printResult(numKLenSubstrNoRepeats("havefunonleetcode", 5), 6)
    printResult(numKLenSubstrNoRepeats("home", 5), 0)
    printResult(numKLenSubstrNoRepeats("h", 1), 1)
}

private fun numKLenSubstrNoRepeats(s: String, k: Int): Int {
    if (s.length < k) return 0
    var answer = 0
    val slidingMap = HashMap<Char, Int>()
    for (i in 0 until k)
        slidingMap[s[i]] = slidingMap.getOrDefault(s[i], 0) + 1
    if (slidingMap.size == k)
        answer++
    for (i in k..s.lastIndex) {
        slidingMap[s[i]] = slidingMap.getOrDefault(s[i], 0) + 1
        val minusCharValue = slidingMap[s[i - k]]!!
        if (minusCharValue == 1)
            slidingMap.remove(s[i - k])
        else
            slidingMap[s[i - k]] = minusCharValue - 1
        if (slidingMap.size == k)
            answer++
    }
    return answer
}
