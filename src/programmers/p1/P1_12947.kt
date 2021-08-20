package programmers

fun main() {
    println(solution(10))
    println(solution2(12))
    println(solution(11))
    println(solution2(13))
}

private fun solution(x: Int): Boolean = x % x.toString().map { v -> Character.getNumericValue(v) }.reduce { a, b -> a + b } == 0
private fun solution2(x: Int): Boolean = x % x.toString().map { v -> Character.getNumericValue(v) }.sum() == 0
