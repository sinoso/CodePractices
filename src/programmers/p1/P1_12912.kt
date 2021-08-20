package programmers


fun main() {
    println(solution(3, 5))
}

private fun solution(a: Int, b: Int): Long {
    var answer: Long
    val max = a.coerceAtLeast(b)
    val min = a.coerceAtMost(b)
    answer = min.toLong()
    for (i in 1 until max - min + 1) {
        answer += min + i.toLong()
    }
    return answer
}