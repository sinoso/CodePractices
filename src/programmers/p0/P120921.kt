package programmers.p0


fun main() {
    println(solution("hello", "hello"))

}

private fun solution(A: String, B: String): Int {
    val long = A + A
    if (!long.contains(B))
        return -1
    val index = long.indexOf(B)
    if (index == 0)
        return 0
    return A.length - index
}
