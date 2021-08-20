package programmers


fun main() {
    println(solution(6, 8).contentToString())
    println(solution(3, 12).contentToString())
    println(solution(2, 5).contentToString())
}

private fun solution(n: Int, m: Int): IntArray = intArrayOf(gcd(n, m), lcm(n, m))

private fun lcm(a: Int, b: Int): Int = a * b / gcd(a, b)

private fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
