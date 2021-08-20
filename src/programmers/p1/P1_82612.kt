package programmers

//프로그래머스 위클리 챌린지
fun main() {
    println(solution(3, 20, 4))
    println(solution(21, 20, 1))
}

private fun solution(price: Int, money: Int, count: Int): Long = (1..count).map { it * price.toLong() }.sum().let { if (money > it) 0 else it - money }
private fun solution2(price: Int, money: Int, count: Int): Long = (1..count).sumOf { it * price.toLong() }.let { if (money > it) 0 else it - money }