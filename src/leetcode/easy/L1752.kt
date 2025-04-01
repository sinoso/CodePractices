package leetcode.easy

fun main() {


}

private fun check(nums: IntArray): Boolean {
    if (nums.size == 1)
        return true
    var rotated = false
    var index = 0
    while (index < nums.lastIndex) {
        if (nums[index] > nums[index + 1]) {
            if (rotated)
                return false
            rotated = true
        }
        index++
    }
    return !(rotated && nums.first() < nums.last())
}