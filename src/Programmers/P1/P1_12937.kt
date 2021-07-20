package Programmers
fun main() {
    println(solution(4))
    println(solution(3))
}

private fun solution(num: Int): String =if(num%2==0) "Even" else "Odd"