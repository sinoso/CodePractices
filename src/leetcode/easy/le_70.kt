package leetcode.easy

fun main() {
    println(climbStairs(2))
    println(climbStairs(3))
    println(climbStairs(4))
    println(climbStairs(9))
}

private fun climbStairs(n: Int): Int {
    if (n == 1)
        return 1
    if (n == 2)
        return 2
    var pre = 1
    var now = 2
    repeat(n - 2) {
        now = now xor pre
        pre = now xor pre
        now = now xor pre
        now += pre
    }
    return now
}
