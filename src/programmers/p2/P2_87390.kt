package programmers.p2

fun main() {
    println(solution(3, 2, 5).joinToString())
}

private fun solution(n: Int, left: Long, right: Long): IntArray {
    val size = right - left + 1
    val answer = IntArray(size.toInt())
    for ((idx, i) in (left..right).withIndex()) {
        val x = (i % n).toInt()
        val y = (i / n).toInt()
        answer[idx] = if (x > y) (x + 1) else (y + 1)
    } 
    return answer
}
