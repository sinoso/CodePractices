package leetcode.easy

fun main() {

}

private fun findGCD(nums: IntArray): Int {
    var max = Int.MIN_VALUE
    var min = Int.MAX_VALUE
    for (i in nums) {
        max = max.coerceAtLeast(i)
        min = min.coerceAtMost(i)
    }
    return gcd(min, max)
}

private tailrec fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
