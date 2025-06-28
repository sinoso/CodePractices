package leetcode.easy

import tools.checkResult

fun main() {

}

private fun separateDigits(nums: IntArray): IntArray =
    nums.map { it.toString().map { it.digitToInt() } }.flatten().toIntArray()
