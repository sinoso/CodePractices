package leetcode.medium

import printResult


fun main() {
    printResult(closestPrimes(10, 19), intArrayOf(11, 13))
    printResult(closestPrimes(4, 6), intArrayOf(-1, -1))
}

private fun closestPrimes(left: Int, right: Int): IntArray {
    val table = BooleanArray(right + 1)
    // 1 is not prime
    //right>=1
    table[1] = true

    for (target in 2..right) {
        val isComposite = table[target]
        if (isComposite) continue
        for (index in (target + target)..right step target) {
            table[index] = true
        }
    }

    //find Answer
    var closestGap = right
    var lastPrime = -right
    val answer = intArrayOf(-1, -1)
    for (number in left..right) {
        val isComposite = table[number]
        if (isComposite)
            continue
        val gap = number - lastPrime
        if (closestGap > gap) {
            closestGap = gap
            answer[0] = lastPrime
            answer[1] = number
        }
        lastPrime = number
    }
    return answer
}