package Programmers

fun main() {
    println(solution(intArrayOf(4, 3, 2, 1)).contentToString())
    println(solution(intArrayOf(10)).contentToString())
}

private fun solution(arr: IntArray): IntArray = if (arr.size == 1) intArrayOf(-1) else arr.filter { v -> v != arr.min() }.toIntArray()