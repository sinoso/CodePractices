package Programmers

fun main() {
    println(solution(2, 5).contentToString())
    println(solution(4, 3).contentToString())
    println(solution(-4, 2).contentToString())
}

private fun solution(x: Int, n: Int): LongArray {
    return (1L..n).map { v -> v * x }.toLongArray()
}