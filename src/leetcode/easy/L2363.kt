package leetcode.easy

fun main() {

}

private fun mergeSimilarItems(items1: Array<IntArray>, items2: Array<IntArray>): List<List<Int>> {
    val map = hashMapOf<Int, Int>()
    for ((key, value) in items1) {
        map[key] = value
    }
    for ((key, value) in items2) {
        map[key] = (map[key] ?: 0) + value
    }
    return map.entries.sortedBy { it.key }.map { listOf(it.key, it.value) }
}