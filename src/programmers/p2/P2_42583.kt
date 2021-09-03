package programmers.p2

import java.util.*

fun main() {
    println(solution(2, 10, intArrayOf(7, 4, 5, 6)))
}

private fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
    var answer = 0
    var onBridgeWeight = 0
    var bridgeQueue: Queue<Int> = LinkedList()
    for (i in 0 until bridge_length)
        bridgeQueue.offer(0)
    var index = 0
    do {
        answer++
        onBridgeWeight -= bridgeQueue.poll()
        if (index > truck_weights.lastIndex)
            continue
        if (onBridgeWeight + truck_weights[index] <= weight && bridgeQueue.size <= bridge_length) {
            onBridgeWeight += truck_weights[index]
            bridgeQueue.offer(truck_weights[index++])
        }else
            bridgeQueue.offer(0)

    } while (onBridgeWeight > 0)
    return answer
}
