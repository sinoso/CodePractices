package leetcode.medium


fun main() {
}

private fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val answerMap = hashMapOf<String, MutableList<String>>()
    val tableSize = 'z' - 'a' + 1 //26
    val countTable = IntArray(tableSize) { 0 }
    val sb = StringBuilder()
    for (s in strs) {
        sb.setLength(0)
        countTable.fill(0)
        s.forEach { countTable[it - 'a']++ }
        val key = countTable.fold(sb) { acc, i -> acc.append('|').append(i) }.toString()
        answerMap[key] = (answerMap[key] ?: mutableListOf()).apply { add(s) }
    }
    return answerMap.entries.map { it.value }
}

private fun groupAnagrams2(strs: Array<String>): List<List<String>> {
    val answerMap = hashMapOf<HashMap<Char, Int>, MutableList<String>>()
    strs.forEach {
        val keyMap = it.fold(hashMapOf<Char, Int>()) { acc, c ->
            acc[c] = (acc[c] ?: 0) + 1
            acc
        }
        answerMap[keyMap] = (answerMap[keyMap] ?: mutableListOf()).apply { add(it) }
    }
    return answerMap.entries.map { it.value }
}

private fun groupAnagrams3(strs: Array<String>): List<List<String>> =
    strs.groupBy {
        it.groupingBy { c -> c }
            .eachCount()
    }
        .entries
        .map { it.value }
