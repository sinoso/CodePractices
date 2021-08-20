package programmers
fun main() {
    System.out.println(solution("Zbcdefg"))
}
private fun solution(s: String): String {
    val a = s.toCharArray()
            a.sortDescending()
    return String(a)
}