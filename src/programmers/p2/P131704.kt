package programmers.p2

import printResult
import java.util.*


fun main() {
    printResult(solution(intArrayOf(4, 3, 1, 2, 5)), 2)
    printResult(solution(intArrayOf(5, 4, 3, 2, 1)), 5)

}

private fun solution(order: IntArray): Int {
    val subRail: Deque<Int> = LinkedList()
    val lastIndex = order.lastIndex
    var answer = 0
    var pointer = 0
    var currentBox = 0
    while (true) {
        currentBox++
        subRail.push(currentBox)
        if (pointer > lastIndex)
            break
        if (currentBox > lastIndex + 1)
            break
        while (pointer <= lastIndex && subRail.peekFirst() == order[pointer]) {
            subRail.pop()
            answer++
            pointer++
        }
    }
    return answer
}
