package leetcode.medium

fun main() {
    println(allPathsSourceTarget(arrayOf(intArrayOf(1, 2), intArrayOf(3), intArrayOf(3), intArrayOf())))
}

private fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
    return search(graph, mutableListOf(0), 0)
}

private fun search(
    graph: Array<IntArray>,
    history: MutableList<Int>,
    currentIndex: Int
): MutableList<MutableList<Int>> {
    if (currentIndex == graph.lastIndex)
        return mutableListOf(history)
    return graph[currentIndex].map { nextIndex ->
        search(graph, history.toMutableList().apply { add(nextIndex) }, nextIndex)
    }.flatten().toMutableList()
}
