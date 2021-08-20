package programmers.p2


fun main() {
    println(solution(intArrayOf(2, 1, 3, 2), 2))
    println(solution(intArrayOf(1, 1, 9, 1, 1, 1), 0))
}

private fun solution(priorities: IntArray, location: Int): Int {
    var answer = 0
    var queueList = MutableList(priorities.size) { v -> v }
    var lastIndex = -1
    while (lastIndex != location) {
        if (priorities.max() == priorities[queueList[0]]) {
            priorities[queueList[0]] = -1
            lastIndex = queueList[0]
            answer++
        } else
            queueList.add(queueList[0])
        queueList.removeAt(0)
    }
    return answer
}
