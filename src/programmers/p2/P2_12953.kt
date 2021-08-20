package programmers.p2

import kotlin.math.*

fun main() {
    println(solution(intArrayOf(2, 6, 8, 14)))
    println(solution(intArrayOf(3, 4, 9, 16)))
}


private fun solution(arr: IntArray): Int {
    var primes = IntArray(101) { v -> v }
    primes[1] = 0
    for (i in 2..primes.lastIndex) {
        if (primes[i] == 0)
            continue
        for (j in i + i..primes.lastIndex step i) {
            if (primes[j] == 0)
                continue
            else
                primes[j] = 0
        }
    }
    var primeset = primes.toMutableSet()
    primeset.remove(0)
    primes = primeset.toIntArray()
    var primesTries = IntArray(primes.size)
    for (i in arr) {
        var value = i
        while (value > 1) {
            for (j in primes.indices) {
                if (value == 1)
                    break
                var tries = 0
                var prime = primes[j]
                while (value % prime == 0) {
                    value /= prime
                    tries++
                }
                primesTries[j] = max(primesTries[j], tries)
            }
        }
    }
    return primesTries.indices.filter { v -> primesTries[v] != 0 }.map { v -> primes[v].toDouble().pow(primesTries[v]) }.reduce { a, b -> a * b }.toInt()
}