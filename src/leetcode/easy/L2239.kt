package leetcode.easy

fun main() {

}

private fun findClosestNumber(nums: IntArray): Int = nums
    .reduce { acc, i ->
        if (Math.abs(acc) == Math.abs(i))
            return@reduce acc.coerceAtLeast(i)
        if (Math.abs(acc) < Math.abs(i))
            return@reduce acc
        return@reduce i
    }
