package leetcode.medium

import printResult

fun main() {
//    printResult(hasAllCodes("00110110", 2), true)
//    printResult(hasAllCodes("00110110", 1), true)
    printResult(hasAllCodes("01100", 2), true)
}

private fun hasAllCodes(s: String, k: Int): Boolean {
    if (s.length < k)
        return false
    val count = (1).shl(k)
    val set = hashSetOf<String>()
    val sb = StringBuilder(s.substring(0 until k))
    set.add(sb.toString())
    val lastIndex = s.lastIndex
    for (i in k - 1..lastIndex) {
        sb.append(s[i])
        sb.deleteCharAt(0)
        set.add(sb.toString())
        if (set.size == count)
            return true
    }
    return false
}
