package leetcode.medium

fun main() {
}

private fun findWinners(matches: Array<IntArray>): List<List<Int>> {
    val map = HashMap<Int, Int>()
    val map2 = map.toSortedMap()
    map2[1] = 1
    for ((winner, loser) in matches) {
        map[winner] = map[winner] ?: 0
        map[loser] = (map[loser] ?: 0) + 1
    }
    val list = mutableListOf<Int>()
    val list2 = mutableListOf<Int>()
    for ((key, value) in map) {
        when (value) {
            0 -> list.add(key)
            1 -> list2.add(key)
        }
    }
    return listOf(list.sorted(), list2.sorted())
}

private fun findWinners2(matches: Array<IntArray>): List<List<Int>> {
    val map = HashMap<Int, Int>()
    for ((winner, loser) in matches) {
        map[winner] = map[winner] ?: 0
        map[loser] = (map[loser] ?: 0) + 1
    }
    return listOf(map.filter { it.value == 0 }.keys.sorted(), map.filter { it.value == 1 }.keys.sorted())
}
