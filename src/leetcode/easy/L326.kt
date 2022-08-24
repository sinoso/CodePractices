package leetcode.easy

fun main() {

}

private fun isPowerOfThree(n: Int): Boolean {
    if (n == 0)
        return false
    if (n == 1)
        return true
    val q = n / 3
    val r = n % 3
    if (r != 0)
        return false
    if (q != 1)
        return isPowerOfThree(q)
    return true
}


private fun isPowerOfThree2(n: Int): Boolean {
    if (n == 0)
        return false
    if (n == 1)
        return true
    var left = n
    while (left % 3 == 0) {
        left /= 3
    }
    return left == 1
}

