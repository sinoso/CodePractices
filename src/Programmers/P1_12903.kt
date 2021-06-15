package Programmers

fun main() {
    System.out.println(solution("abcde"))
}
fun solution(s: String): String {
    var answer = ""
    var length = s.length
    if (length % 2 == 0)
        answer = s.substring(length / 2 - 1, length / 2 + 1)
    else
        answer = s.substring(length / 2, length / 2 + 1)
    return answer
}