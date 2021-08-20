package programmers

fun main() {
    println(solution(0))
    println(solution(1))
    println(solution(2))
    println(solution(5))
    println(solution(12))
}

private fun solution(n: Int): Int = (1..n).filter {n % it == 0 }.sum()
private fun solution2(n: Int): Int = (1..n).filter { v -> n % v == 0 }.foldRight(0) { total, v -> total + v }