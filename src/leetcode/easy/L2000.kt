package leetcode.easy

fun main() {

}

private fun minBitFlips(start: Int, goal: Int): Int = Integer.bitCount(start xor goal)
