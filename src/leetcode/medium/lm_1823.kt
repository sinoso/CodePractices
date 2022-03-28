package leetcode.medium

import printResult
import java.util.*

fun main() {
    printResult(findTheWinner(5, 2), 3)
    printResult(findTheWinner(6, 5), 1)
}

private fun findTheWinner(n: Int, k: Int): Int =
    (1..n).fold(0) { acc, i -> (acc + k) % i } + 1

private fun findTheWinner2(n: Int, k: Int): Int {
    val list = LinkedList<Int>()
    repeat(n) { list.add(it) }
    var left = list.size
    val needToMove = k - 1
    var idx = needToMove
    while (left > 1) {
        list.removeAt(idx)
        idx += needToMove
        left = list.size
        idx %= left
    }
    return list.first + 1
}
