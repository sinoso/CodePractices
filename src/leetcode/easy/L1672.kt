package leetcode.easy

fun main() {
    println(maximumWealth(arrayOf(intArrayOf(1, 2, 3), intArrayOf(3, 2, 1))))
}

private fun maximumWealth(accounts: Array<IntArray>): Int {
    var max = 0
    accounts.forEach { max = max.coerceAtLeast(it.sum()) }
    return max
}

//196 ms  36.8 MB
private fun maximumWealth2(accounts: Array<IntArray>): Int =
        accounts.map { it.sum() }.maxOrNull() ?: 0 //not work in leetcode
//        accounts.map { it.sum() }.max() ?: 0

