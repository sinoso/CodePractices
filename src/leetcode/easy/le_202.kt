package leetcode.easy

import printResult

fun main() {
    printResult(isHappy(2), false)
    printResult(isHappy(19), true)
}

private fun isHappy(n: Int): Boolean {
    var nextValue = n
    val set = hashSetOf<Int>()
    while (!set.contains(nextValue) && nextValue != 1) {
        set.add(nextValue)
        nextValue = nextValue.toString().map { (it - '0') }.fold(0) { acc, i -> acc + i * i }
    }
    return nextValue == 1
}
