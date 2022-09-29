package leetcode.medium

import java.util.*


fun main() {
}

private fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
    val priorityQueue =
        PriorityQueue<Int>(compareBy<Int?> { (it!! - x).let { result -> if (result < 0) result * -1 else result } }.thenBy { it })
    arr.forEach { priorityQueue.add(it) }
    val answer: MutableList<Int> = mutableListOf()
    repeat(k){
        answer.add(priorityQueue.poll())
    }
    return answer.sorted()
}
