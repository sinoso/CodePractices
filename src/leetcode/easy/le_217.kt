package leetcode.easy


fun main() {
    println(containsDuplicate(intArrayOf(1, 2, 3, 4)))
    println(containsDuplicate(intArrayOf(1, 2, 3, 1)))
}

private fun containsDuplicate(nums: IntArray): Boolean {
    if (nums.size == 1)
        return false
    val nums2 = nums.sorted()
    var idx = 1
    while (idx < nums2.size)
        if (nums2[idx - 1] == nums2[idx++])
            return true
    return false
}
