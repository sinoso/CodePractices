package leetcode.easy

import printResult

fun main() {
}

private fun prefixCount(words: Array<String>, pref: String): Int {
    var answer = 0
    for (word in words) {
        if (word.length == pref.length)
            continue
        var flag = false
        for (i in pref.indices) {
            flag = pref[i] == word[i]
            if (!flag)
                break
        }
        if (flag)
            answer++
    }
    return answer
}

private fun prefixCount2(words: Array<String>, pref: String): Int = words.count { it.startsWith(pref) }
