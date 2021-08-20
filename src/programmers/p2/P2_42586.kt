package programmers.p2

import java.util.*


fun main() {
    println(solution(intArrayOf(93, 30, 55), intArrayOf(1, 30, 5)).joinToString())
}

private fun solution(progresses: IntArray, speeds: IntArray): IntArray {
    var now = (99 - progresses[0]) / speeds[0] + 1
    var result = 0
    var idx = 0
    var new: Int
    for (i in progresses.indices) {
        new = (99 - progresses[i]) / speeds[i] + 1
        if (new <= now) {
            result++
            continue
        }
            now = new
            progresses[idx++] = result
            result = 1
    }
    progresses[idx] = result
    return IntArray(idx+1){v-> progresses[v]}
}
private fun solution2(progresses: IntArray, speeds: IntArray): IntArray {
    var now = (99 - progresses[0]) / speeds[0] + 1
    var result = 0
    var idx = 0
    for (i in progresses.indices) {
        var new = (99 - progresses[i]) / speeds[i] + 1
        if (new <= now) {
            result++
        } else {
            now = new
            progresses[idx++] = result
            result = 1
        }
    }
    progresses[idx++] = result
    return progresses.copyOf(idx)
}
private fun solution3(progresses: IntArray, speeds: IntArray): IntArray {
    var answer = mutableListOf<Int>()
    var maxFlag = progresses.size
    var queue = LinkedList<Int>().also { for (i in progresses.indices) it.add(i) }
    var flag = 0
    while (flag < maxFlag) {
        for (i in queue)
            progresses[i] += speeds[i]
        if (progresses[queue[0]] > 99) {
            var result = 0
            while (progresses[queue[0]] > 99) {
                flag++
                result++
                queue.removeAt(0)
                if (queue.isEmpty())
                    break
            }
            answer.add(result)
        }
    }
    return answer.toIntArray()
}

private fun solution4(progresses: IntArray, speeds: IntArray): IntArray {
    var answer = mutableListOf<Int>()
    var lastIdx = progresses.lastIndex
    var idx = 0
    while (idx <= lastIdx) {
        for (i in idx..lastIdx)
            progresses[i] += speeds[i]
        var result = 0
        while (idx <= lastIdx && progresses[idx] > 99) {
            idx++
            result++
        }
        if (result != 0)
            answer.add(result)
    }
    return answer.toIntArray()
}