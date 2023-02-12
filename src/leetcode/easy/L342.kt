package leetcode.easy

fun main() {
    isPowerOfFour(16)
}

private fun isPowerOfFour(n: Int): Boolean {
    var left = n
    if (n < 1)
        return false
    while (left > 1) {
        if (left % 4 != 0)
            return false
        left /= 4
    }
    return true
}
