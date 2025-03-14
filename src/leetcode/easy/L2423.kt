package leetcode.easy

import printResult

fun main() {
    printResult(actual = equalFrequency("abc"), expected = true)
//    printResult(actual = equalFrequency("abcc"), expected = true)
    printResult(actual = equalFrequency("aazz"), expected = false)

}

private fun equalFrequency(word: String): Boolean {
    val map = HashMap<Char, Int>()
    for (c in word) {
        map[c] = (map[c] ?: 0) + 1
    }
    //모두 같은 글자이면
    if (map.size == 1)
        return true

    val valueCountMap = HashMap<Int, Int>()
    for ((k, v) in map) {
        valueCountMap[v] = (valueCountMap[v] ?: 0) + 1
    }
    // 2종류가 아니라면
    val entries = valueCountMap.entries.toList().sortedBy { it.key }
    if (entries.size == 1 && entries[0].key == 1)
        return true
    if (entries.size != 2)
        return false
    val small = entries[0]
    val big = entries[1]
    if (small.key == 1 && small.value == 1)
        return true
    if (big.value == 1 && (big.key - small.key == 1))
        return true
    return false
}