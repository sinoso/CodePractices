package Programmers

fun main() {
    println(solution("01033334444"))
    println(solution("027778888"))
    println(solution("1234"))
}

private fun solution(phone_number: String): String {
    return (0..phone_number.lastIndex - 4).map { "*" }.joinToString("") + phone_number.substring(phone_number.lastIndex - 3)
}