package programmers.p0

import java.math.BigInteger


fun main() {
}

private fun solution(balls: Int, share: Int): BigInteger {
    val head = ((balls - share + 1)..balls).toMutableSet()
    val body = (1..share).toMutableSet()
    for (i in head.toList()) {
        if (body.contains(i)) {
            head.remove(i)
            body.remove(i)
        }
    }
    return head.fold(BigInteger.valueOf(1L)) { acc, i -> acc * BigInteger.valueOf(i.toLong()) } /
            body.fold(BigInteger.valueOf(1L)) { acc, i -> acc * BigInteger.valueOf(i.toLong()) }
}
