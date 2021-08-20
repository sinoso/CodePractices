package programmers

fun main() {
    println(solution(8, 12))
}

private fun solution(w: Int, h: Int): Long {
    return w * h.toLong() - (h + w - gcd(w, h).toLong())
}

private fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
}
