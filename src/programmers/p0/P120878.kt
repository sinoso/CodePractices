package programmers.p0

fun main() {
    println(solution(12, 36))
    println(solution(1, 70))
}

private fun solution(a: Int, b: Int): Int {
    val gcd = gcd(a, b)
    var newB = b / gcd
    while (newB >= 5) {
        if (newB % 5 != 0)
            break
        newB /= 5
    }
    while (newB >= 2) {
        if (newB % 2 != 0)
            return 2
        newB /= 2
    }
    return 1
}

private tailrec fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
