package leetcode.easy


fun main() {
}

private fun isUgly(n: Int): Boolean {
    if (n == 0)
        return false
    var left = n
    while (left % 3 == 0) {
        left /= 3
    }
    while (left % 2 == 0) {
        left /= 2
    }
    while (left % 5 == 0) {
        left /= 5
    }
    return left == 1
}