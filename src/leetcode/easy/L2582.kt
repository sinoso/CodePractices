package leetcode.easy

fun main() {
    passThePillow(9, 4)
}

private fun passThePillow(n: Int, time: Int): Int {
    val isGoToN = ((time / (n - 1)) and 1) == 0
    return if (isGoToN) time % (n - 1) + 1 else n - time % (n - 1)
}
