package leetcode.medium

import printResult


fun main() {
    printResult(killProcess(listOf(1, 3, 10, 5), listOf(3, 0, 5, 3), 5), listOf(5, 10))
}

private fun killProcess(pid: List<Int>, ppid: List<Int>, kill: Int): List<Int> {
    val map: MutableMap<Int, MutableSet<Int>> = mutableMapOf()
    for (i in pid.indices) {
        val currentSet = map[ppid[i]] ?: mutableSetOf()
        currentSet.add(pid[i])
        map[ppid[i]] = currentSet
    }
    return getAllChild(map, kill) + kill
}

private fun getAllChild(map: Map<Int, Set<Int>>, kill: Int): List<Int> {
    val currentSet:Set<Int> = map[kill] ?: return mutableListOf()

    return currentSet.map { getAllChild(map,it) }.flatten() + currentSet.toList()
}
