package Programmers

import java.util.regex.Pattern

fun main() {
    System.out.println(solution("1234"))
}

private fun solution(s: String): Boolean {
    return (s.length==4||s.length==6)&&s.toIntOrNull()!=null
}
private fun solution2(s: String): Boolean {
    return (s.length == 4 || s.length == 6) && Pattern.matches("^[0-9]+$", s)
}