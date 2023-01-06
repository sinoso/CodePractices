package leetcode.medium

import java.util.PriorityQueue

fun main() {

}

private fun maxIceCream(costs: IntArray, coins: Int): Int {
    val priorityQueue = PriorityQueue<Int>(compareByDescending { it })
    var leftCoin = coins
    for (cost in costs) {
        if (leftCoin > cost) {
            leftCoin -= cost
            priorityQueue.offer(cost)
            continue
        }
        if (priorityQueue.isNotEmpty() && priorityQueue.peek() > cost) {
            leftCoin += priorityQueue.poll()
            leftCoin -= cost
            priorityQueue.offer(cost)
        }
    }
    return priorityQueue.size
}

private fun maxIceCream2(costs: IntArray, coins: Int): Int {
    costs.sort()
    var left = coins
    var count = 0
    var index = 0
    val costsSize = costs.size
    while (index < costsSize) {
        left -= costs[index++]
        if (left < 0) {
            break
        }
        count++
    }
    return count
}