package leetcode.medium

import printResult

fun main() {
    printResult(countPrimes(10), 4)
    printResult(countPrimes(1), 0)
    printResult(countPrimes(0), 0)
}

private fun countPrimes(n: Int): Int {
    if (n < 3) return 0
    val array = Array(n) { true }.apply {
        this[0] = false
        this[1] = false
    }
    for (i in 2..Math.sqrt(n.toDouble()).toInt()) {
        if (array[i]) {
            var j = i + i
            while (j < n) {
                array[j] = false
                j += i
            }
        }
    }
    return array.count { it }
}

private fun countPrimes2(n: Int): Int {
    val array = Array(n) { true }
    var answer = 0
    for (i in 2..array.lastIndex) {
        if (array[i]) {
            answer++
            var j = i + i
            while (j < n) {
                array[j] = false
                j += i
            }
        }
    }
    return answer
}

