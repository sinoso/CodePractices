package programmers.p1

import java.util.PriorityQueue

fun main() {

}

private fun solution(k: Int, score: IntArray): IntArray {
    val priorityQueue = PriorityQueue<Int>()
    val answer = IntArray(score.size)
    for (i in score.indices) {
        priorityQueue.add(score[i])
        if (priorityQueue.size > k)
            priorityQueue.poll()
        answer[i] = priorityQueue.peek()
    }

    return answer
}