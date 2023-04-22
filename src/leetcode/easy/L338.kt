package leetcode.easy

fun main() {
    println(countBits(2).joinToString())
    println(countBits(5).joinToString())
}

private fun countBits(n: Int): IntArray = (0..n).map(Integer::bitCount).toIntArray()

