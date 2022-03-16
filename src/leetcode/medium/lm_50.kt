package leetcode.medium

import printResult

fun main() {
    printResult(myPow(x = 2.00000, n = 10), 1024.00000)
    printResult(myPow(x = 2.10000, n = 3), 9.26100)
    printResult(myPow(x = 1.1, n = 2147483647), 1.1)
    printResult(myPow(x = 2.0, n = -2147483648), 1.1)
    printResult(myPow(x = 1.1, n = 0), 1.0)
}

private fun myPow(x: Double, n: Int): Double {
    if (x == 1.0)
        return 1.0
    var answer = 1.0
    var multi = if (n > 0) x else 1 / x
    var left = if (n > 0) n.toLong() else (n * -1).toLong()
    while (left != 0L) {
        if (left and 1L == 1L) {
            left--
            answer *= multi
        }
        multi *= multi
        left /= 2
    }
    return answer
}

private fun myPow2(x: Double, n: Int): Double {
    if (x == 1.0)
        return 1.0
    var answer = 1.0
    var multi = if (n > 0) x else 1 / x
    var left = n
    val leftMinus = if (n > 0) -1 else 1
    while (left != 0) {
        if (left and 1 == 1) {
            left += leftMinus
            answer *= multi
        }
        multi *= multi
        left /= 2
    }
    return answer
}

private fun myPow3(x: Double, n: Int): Double {
    var answer = 1.0
    if (n == 0)
        return answer
    var count = 0
    var multi = x
    var times = n
    if (n > 0)
        while (count++ < times)
            answer *= multi
    else
        while (count-- > times)
            answer /= multi
    return answer
}
