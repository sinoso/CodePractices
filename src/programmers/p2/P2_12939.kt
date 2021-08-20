package programmers.p2

fun main() {
    println(solution("1 2 3 4"))
    println(solution("-1 -2 -3 -4"))
    println(solution("-1 -1"))
}

private fun solution(s: String): String = s.split(" ").map { it.toInt() }.let { "${it.min()} ${it.max()}" }

private fun solution2(s: String): String {
    var intArray = s.split(" ").map { v -> v.toInt() }
    return "${intArray.min()} ${intArray.max()}"
}
