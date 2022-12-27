package leetcode.medium

import java.util.*


fun main() {

}

private fun maximumBags(capacity: IntArray, rocks: IntArray, additionalRocks: Int): Int {
    val priorityQueue = PriorityQueue<Int>()
    var answer = 0
    for (i in capacity.indices) {
        val diff = capacity[i] - rocks[i]
        if (diff == 0) {
            answer++
            continue
        }
        priorityQueue.add(diff)
    }
    var leftRock = additionalRocks
    while (priorityQueue.isNotEmpty() && leftRock > 0) {
        val currentNeed = priorityQueue.poll()
        if (currentNeed > leftRock) {
            break
        }
        leftRock -= currentNeed
        answer++
    }
    return answer
}
