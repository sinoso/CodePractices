package Programmers

fun main() {
    println(solution(arrayOf("Jane", "Kim")))
}

private fun solution(seoul: Array<String>): String = "김서방은 ${seoul.indexOf("Kim")}에 있다"