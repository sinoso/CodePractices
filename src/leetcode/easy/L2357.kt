package leetcode.easy

fun main() {

}

private fun minimumOperations(nums: IntArray): Int = nums
    .toHashSet()
    .run {
        this.size + if (0 in this) -1 else 0
    }
