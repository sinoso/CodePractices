package programmers

fun main() {
    println(solution(123))
    println(solution(100000000))
}

private fun solution(n: Int): Int = n.toString().sumBy { v -> Character.getNumericValue(v) }