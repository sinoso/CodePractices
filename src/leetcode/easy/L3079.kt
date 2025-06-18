package leetcode.easy

fun main() {
}

private fun sumOfEncryptedInt(nums: IntArray): Int =
    nums.map {
        val s = it.toString()
        val max = s.maxOf { it }
        ("$max").repeat(s.length).toInt()
    }.sum()