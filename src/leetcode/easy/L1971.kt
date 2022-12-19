package leetcode.easy

import java.util.*
import kotlin.collections.HashMap

fun main() {
    validPath(
        10,
        arrayOf(
            intArrayOf(0, 7),
            intArrayOf(0, 8),
            intArrayOf(6, 1),
            intArrayOf(2, 0),
            intArrayOf(0, 4),
            intArrayOf(5, 8),
            intArrayOf(4, 7),
            intArrayOf(1, 3),
            intArrayOf(3, 5),
            intArrayOf(6, 5)
        ),
        7,
        5
    )
}

private fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
    if (source == destination)
        return true
    val queue = LinkedList<Int>()
    val map = HashMap<Int, MutableList<Int>>()
    edges.forEach { (from, to) ->
        map[from] = (map[from] ?: mutableListOf()).apply { add(to) }
        map[to] = (map[to] ?: mutableListOf()).apply { add(from) }
    }
    val checked = mutableSetOf<Int>()
    checked.add(source)
    queue.addAll(map[source] ?: mutableListOf())
    while (checked.size < n && queue.isNotEmpty()) {
        val next = queue.poll()
        if (next == destination)
            return true
        if (checked.add(next)) {
            map[next]?.let(queue::addAll)
        }
    }
    return false
}
