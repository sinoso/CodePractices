package leetcode.easy

fun main() {
    println(arrangeCoins(5))
    println(arrangeCoins(8))
    println(arrangeCoins(1))
    println(arrangeCoins(3))
    println(arrangeCoins(6))
    println(arrangeCoins(10))
    println(arrangeCoins(Int.MAX_VALUE))
}

private fun arrangeCoins(n: Int): Int {
    var a = n
    var i = 0
    while (a >= 0)
        a -= ++i
    return i - 1
}
