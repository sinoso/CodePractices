package leetcode.medium

import java.util.*
import kotlin.collections.HashSet

fun main() {
    println(lengthOfLongestSubstring("abcabcbb"))
    println(lengthOfLongestSubstring(" "))
    println(lengthOfLongestSubstring(" a"))
    println(lengthOfLongestSubstring("aab"))
}

private fun lengthOfLongestSubstring(s: String): Int {
    var max = 0
    val list = LinkedList<Char>()
    for (char in s) {
        val index = list.indexOf(char)
        list.add(char)
        if (index > -1) {
            repeat(index + 1) { list.remove() }
            continue
        }
        max = max.coerceAtLeast(list.size)
    }
    return max
}

private fun lengthOfLongestSubstring2(s: String): Int {
    var max = 0
    val set = HashSet<Char>()
    for (idx in s.indices) {
        if (s.lastIndex - idx < max)
            break
        for (subIdx in idx..s.lastIndex)
            if (!set.add(s[subIdx]))
                break
        max = max.coerceAtLeast(set.size)
        set.clear()
    }
    return max
}
