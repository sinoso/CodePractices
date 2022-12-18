package leetcode.medium

import java.util.*

fun main() {

}

private fun dailyTemperatures(temperatures: IntArray): IntArray {
    val queue = PriorityQueue(compareBy<Pair<Int, Int>> { it.first })
    val answer = IntArray(temperatures.size)
    for (currentIndex in temperatures.indices) {
        while (queue.isNotEmpty() && queue.peek().first < temperatures[currentIndex]) {
            val targetIndex = queue.poll().second
            answer[targetIndex] = currentIndex - targetIndex
        }
        queue.add(temperatures[currentIndex] to currentIndex)
    }
    return answer
}
