package leetcode.easy

fun main() {
    println(plusOne(intArrayOf(1, 2, 3)).joinToString())
    println(plusOne(intArrayOf(9)).joinToString())
}

private fun plusOne(digits: IntArray): IntArray {
    var acc = true
    var idx = digits.lastIndex
    while (acc && idx >= 0) {
        acc = digits[idx] == 9
        if (acc)
            digits[idx--] = 0
        else
            digits[idx] += 1
    }
    if (idx < 0) {
        val answer = IntArray(digits.size + 1)
        answer[0] = 1
        (1..answer.lastIndex).forEach { answer[it] = digits[it - 1] }
        return answer
    }
    return digits
}
