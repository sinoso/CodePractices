package programmers.p1

fun main() {
    println(solution(intArrayOf(1, 2, 3, 4, 6, 7, 8, 0)))
    println(solution(intArrayOf(5, 8, 4, 0, 6, 7, 9)))
}

private fun solution(numbers: IntArray): Int = 45 - numbers.sum()