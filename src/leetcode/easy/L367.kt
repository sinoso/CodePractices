package leetcode.easy

fun main() {
//    isPerfectSquare(2147483647)
    isPerfectSquare(20)
}

private fun isPerfectSquare(num: Int): Boolean {
    val numL = num.toLong()
    var left = 0L
    var right = numL
    while (left < right) {
        val mid = (left + right) / 2
        val midSq = mid * mid
        if (midSq < num) {
            left = mid + 1
        } else if (midSq == numL) {
            return true
        } else {
            right = mid - 1
        }
    }
    return left == right && left * right == numL
}
