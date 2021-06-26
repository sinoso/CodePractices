package Programmers

fun main() {
    println(solution("1234"))
}

private fun solution(s: String): Int {
    return when{
                s.substring(0,1) == "-" ->
                    Integer.parseInt(s.substring(1,s.length)) *-1
                s.substring(0,1) == "+" ->
                    Integer.parseInt(s.substring(1,s.length))
                else ->
                    Integer.parseInt(s)
            }
}
private fun solution2(s: String): Int {
    return when {
        s[0] == '-' ->
            Integer.parseInt(s.substring(1, s.length)) * -1
        s[0] == '+' ->
            Integer.parseInt(s.substring(1, s.length))
        else ->
            Integer.parseInt(s)
    }
}
private fun solution3(s: String): Int {
    return s.toInt()
}