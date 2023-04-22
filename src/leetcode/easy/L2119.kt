package leetcode.easy

fun main() {
    println(isSameAfterReversals(100))
    println(isSameAfterReversals(1))
    println(isSameAfterReversals(0))
}

private fun isSameAfterReversals(num: Int): Boolean = num == 0 || num % 10 != 0
