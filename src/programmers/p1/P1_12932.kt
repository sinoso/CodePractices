package programmers

fun main() {
    println(solution(1234).joinToString())
    println(solution(3).joinToString())
}

private fun solution(n: Long): IntArray = n.toString().reversed().map { v -> Character.getNumericValue(v) }.toIntArray()
