package leetcode.easy

fun main() {

}

private fun maximumPopulation(logs: Array<IntArray>): Int {
    val prefix = 1950
    val table = IntArray(101)
    for ((start, end) in logs) {
        table[start - prefix]++
        table[end - prefix]--
    }
    var max = 0
    var year = 0
    var count = 0
    for (i in table.indices) {
        count += table[i]
        if (count > max) {
            max = count
            year = i
        }
    }
    return year + prefix
}

private fun maximumPopulation2(logs: Array<IntArray>): Int {
    val table = HashMap<Int, Int>()
    for ((start, end) in logs) {
        for (i in start until end) {
            table[i] = (table[i] ?: 0) + 1
        }
    }
    return table.entries.sortedBy { it.key }.maxBy { it.value }.key
}