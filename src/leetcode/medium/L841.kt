package leetcode.medium

import java.util.LinkedList
import java.util.Queue

fun main() {
    canVisitAllRooms(listOf(listOf(1), listOf(2), listOf(3), listOf()))
}

private fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
    val visited = mutableSetOf(0)
    var count = 1
    val queue: Queue<Int> = LinkedList()
    queue.offer(0)
    while (queue.isNotEmpty()) {
        val currentKey = queue.poll()
        val currentRoomResult = rooms[currentKey]
        currentRoomResult.forEach {
            if (visited.add(it)) {
                queue.offer(it)
                count++
            }
        }
    }
    return count == rooms.size
}