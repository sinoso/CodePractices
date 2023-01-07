package leetcode.easy


fun main() {
    countDigits(111)
}

private fun countDigits(num: Int): Int {
    if (num < 10)
        return 1

    val numString = num.toString()
    var count = 0
    for (c in numString) {
        if (num % (c - '0') == 0)
            count++
    }
    return 1
}
