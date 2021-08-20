package programmers


fun main() {
    println(solution(118372))
    println(solution(80000001000))
}

private fun solution(n: Long): Long = n.toString().map { v -> Character.getNumericValue(v) }.sortedDescending().joinToString("").toLong()
private fun solution2(n: Long): Long = String(n.toString().toCharArray().sortedArrayDescending()).toLong()