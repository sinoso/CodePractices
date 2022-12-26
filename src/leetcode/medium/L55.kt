package leetcode.medium

fun main() {
    canJump(intArrayOf(0,1))
}

private fun canJump(nums: IntArray): Boolean {
    var lastIndex = nums.lastIndex
    var currentIndex = nums.lastIndex
    while (currentIndex != 0) {
        currentIndex--
        if (lastIndex - currentIndex <= nums[currentIndex]){
            lastIndex = currentIndex
        }
    }
    return lastIndex == 0
}
