package leetcode.medium

fun main() {

}

private fun frequencySort(s: String): String {
    val map = HashMap<Char, Int>()
    for (c in s) {
        map[c] = (map[c] ?: 0) + 1
    }
    val sortedEntries = map.entries.sortedByDescending { it.value }
    val answer = StringBuilder()
    var count = 0
    for ((key, value) in sortedEntries) {
        count = 0
        while (count++ < value) {
            answer.append(key)
        }
    }
    return answer.toString()
}

private fun frequencySort2(s: String): String =
    s.groupingBy { it }
        .eachCount()
        .entries
        .sortedByDescending { it.value }
        .fold(StringBuilder()) { acc, (key, value) ->
            acc.apply {
                repeat(value) { append(key) }
            }
        }.toString()

