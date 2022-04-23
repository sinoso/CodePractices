package programmers.p2

fun main() {
    println(solution(3, 2, 5).joinToString())
}

private fun solution(n: Int, left: Long, right: Long): IntArray {
    return (left..right).map {
        val x = (it % n).toInt()
        val y = (it / n).toInt()
        if (x > y) (x + 1) else (y + 1)
    }.toIntArray()
}
