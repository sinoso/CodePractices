package leetcode.easy

fun main() {

}

private fun smallestEvenMultiple(n: Int): Int = lcm(2, n)

private fun lcm(a: Int, b: Int): Int = a * b / gcd(a, b)

private tailrec fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
