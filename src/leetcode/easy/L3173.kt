package leetcode.easy

fun main() {

}

private fun orArray(nums: IntArray): IntArray = IntArray(nums.lastIndex){ nums[it] or nums[it+1] }