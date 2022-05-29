package leetcode.medium

import printResult

fun main() {
    printResult(customSortString("cba", "abcd"), "cbad")
}

private fun customSortString(order: String, s: String): String {
    val table = IntArray('z' - 'a' + 1)
    for (c in s) {
        table[c - 'a']++
    }
    val sb = StringBuilder()
    var count: Int
    var index: Int
    for (c in order) {
        count = 0
        index = c - 'a'
        while (count++ < table[index]) {
            sb.append(c)
        }
        table[index] = 0
    }
    index = 0
    for (c in 'a'..'z') {
        count = 0
        while (count++ < table[index]) {
            sb.append(c)
        }
        index++
    }
    return sb.toString()
}


private fun customSortString2(order: String, s: String): String {
    val map = HashMap<Char, Int>()
    val sb = StringBuilder()
    for (c in s) {
        map[c] = (map[c] ?: 0) + 1
    }
    for (c in order) {
        val count = map[c] ?: continue
        repeat(count) {
            sb.append(c)
        }
        map[c] = 0
    }
    map.entries
        .sortedBy { it.key }
        .forEach { (key, value) ->
            repeat(value) {
                sb.append(key)
            }
        }
    return sb.toString()
}
