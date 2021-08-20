package programmers
fun main() {
    println(solution("1 2 3 4"))
    println(solution("-1 -2 -3 -4"))
}

private fun solution(s: String): String {
    val intArray = s.split(" ").map { v -> v.toInt() }
    return "${intArray.min()} ${intArray.max()}"
}