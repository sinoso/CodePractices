package leetcode.easy

import java.util.*

fun main() {
    answerQueries(intArrayOf(4, 5, 2, 1), intArrayOf(3, 10, 21))
}

private fun answerQueries(nums: IntArray, queries: IntArray): IntArray {
    val queue = PriorityQueue<Int>()
    nums.forEach { queue.offer(it) }
    val queriesIndexSorted = queries.indices.sortedBy { queries[it] }

    var currentSum = 0
    var count = 0
    queriesIndexSorted.forEach { index ->
        val currentValue = queries[index]
        while (queue.isNotEmpty()) {
            if (currentSum + queue.peek() > currentValue)
                break
            currentSum += queue.poll()
            count++
        }
        queries[index] = count
    }

    return queries
}
