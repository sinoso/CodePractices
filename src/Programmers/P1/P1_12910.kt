package Programmers

fun main() {
    println(solution(intArrayOf(5, 9, 7, 10), 5).contentToString())
}

private fun solution(arr: IntArray, divisor: Int): IntArray {
    var answer = arr.filter { v -> v % divisor == 0 }.sorted().toIntArray()
    return if(answer.isEmpty()) intArrayOf(-1) else answer
}