package leetcode.easy


fun main() {
    pivotInteger(8)
}

private fun pivotInteger(n: Int): Int {
    if (n == 1)
        return n
    var left = (1..n).sum()
    var right = n
    var current = n
    while (current > 0) {
        left -= current
        current--
        right += current
        if (left == right)
            return current
    }
    return -1
}
