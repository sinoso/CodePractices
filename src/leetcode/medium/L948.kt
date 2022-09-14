package leetcode.medium

import printResult

fun main() {
    printResult(bagOfTokensScore(intArrayOf(10, 10, 10, 10, 10), 10), 1)
}

// 23:24 ~ 23:38
private fun bagOfTokensScore(tokens: IntArray, power: Int): Int {
    var leftPower = power
    var score = 0
    tokens.sort()
    var frontIndex = 0
    var rearIndex = tokens.lastIndex
    while (frontIndex <= rearIndex) {
        if (leftPower >= tokens[frontIndex]) {
            leftPower -= tokens[frontIndex]
            frontIndex++
            score++
        } else {
            if (frontIndex == rearIndex)
                break
            if (score > 0) {
                leftPower += tokens[rearIndex]
                rearIndex--
                score--
            } else
                break
        }
    }
    return score
}

private fun bagOfTokensScore2(tokens: IntArray, power: Int): Int {
    var leftPower = power
    var score = 0
    tokens.sort()
    var frontIndex = 0
    var rearIndex = tokens.lastIndex
    while (frontIndex <= rearIndex) {
        when {
            leftPower >= tokens[frontIndex] -> {
                leftPower -= tokens[frontIndex]
                frontIndex++
                score++
            }
            frontIndex != rearIndex && score > 0 -> {
                leftPower += tokens[rearIndex]
                rearIndex--
                score--
            }
            else -> return score
        }
    }
    return score
}
