package programmers.p1

import java.util.*

fun main() {
    println(solution(intArrayOf(2, 1, 1, 2, 3, 1, 2, 3, 1)))
    println(solution(intArrayOf(1, 3, 2, 1, 2, 1, 3, 1, 2)))
    println(solution(intArrayOf(1, 2, 3, 1)))
}

private fun solution(ingredient: IntArray): Int {
    var answer = 0
    val list = LinkedList<Int>()
    for (i in ingredient) {
        val size = list.size
        if (i == 1 && size >= 3) {
            if (list[size - 1] == 3 && list[size - 2] == 2 && list[size - 3] == 1) {
                repeat(3) { list.pollLast() }
                answer++
                continue
            }
        }
        list.offer(i)
    }
    return answer
}
