package Programmers.P2

fun main() {
    println(solution(intArrayOf(3, 0, 6, 1, 5)))
    println(solution(intArrayOf(25, 8, 5, 3, 3)))
    println(solution(intArrayOf(10, 8, 5, 4, 3)))
    println(solution(intArrayOf(10, 10, 10, 10, 10)))
}

private fun solution(citations: IntArray): Int {
    var citation = citations.sorted()
    var answer = 0
    for (i in citation.indices.reversed()) {
        if (citation[i] >= i)
            if (i + 1 <= citation.filter { v -> v >= i + 1 }.size) {
                answer = i + 1
                break
            }
    }
    return answer
}
