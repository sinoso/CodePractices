package leetcode.easy


fun main() {
    println(isMonotonic(intArrayOf(1, 2, 2, 3)))//t
    println(isMonotonic(intArrayOf(6, 5, 4, 4)))//t
    println(isMonotonic(intArrayOf(1, 3, 2)))//f
}


private fun isMonotonic(nums: IntArray): Boolean {
    if (nums.size == 1)
        return true
    var lastflag = 0
    for (idx in 1..nums.lastIndex) {
        if (nums[idx - 1] == nums[idx])
            continue
        val currentValue = nums[idx] - nums[idx - 1]
        if (lastflag < 0 && currentValue > 0)
            return false
        if (lastflag > 0 && currentValue < 0)
            return false
        lastflag = currentValue
    }
    return true
}
