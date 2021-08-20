package programmers

fun main() {
    println(solution(5))
}

private fun solution(n: Int): String = (1..n).joinToString("") { v -> if (v % 2 == 1) "수" else "박" }
