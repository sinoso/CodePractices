package leetcode.easy

fun main() {
    println(singleNumber(intArrayOf(2, 2, 1)))
}

private fun singleNumber(nums: IntArray): Int =
    mutableMapOf<Int, Int>().apply {
        nums.forEach { num -> this[num] = this.getOrDefault(num, 0) + 1 }
    }.entries.first { it.value == 1 }.key

private fun singleNumber2(nums: IntArray): Int =
    mutableMapOf<Int, Int>().apply {
        nums.forEach { num -> this[num] = this.getOrDefault(num, 0) + 1 }
    }.toList().first { it.second == 1 }.first

