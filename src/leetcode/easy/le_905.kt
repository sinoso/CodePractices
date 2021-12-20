package leetcode.easy


fun main() {
    println(sortArrayByParity(intArrayOf(3, 1, 2, 4)).joinToString(","))
    println(sortArrayByParity(intArrayOf(1,2,3,4,5)).joinToString(","))
    println(sortArrayByParity(intArrayOf(0)).joinToString(","))
    println(sortArrayByParity(intArrayOf(0,1)).joinToString(","))
    println(sortArrayByParity(intArrayOf(3,1)).joinToString(","))
}

private fun sortArrayByParity(nums: IntArray): IntArray {
    var left = 0
    var right = nums.lastIndex
    while (left <= right) {
        if (nums[left] and 1 == 0) {
            left++
            continue
        }
        if (nums[right] and 1 == 0) {
            nums[left] = nums[left] xor nums[right]
            nums[right] = nums[left] xor nums[right]
            nums[left] = nums[left] xor nums[right]
        }
        right--
    }
    return nums
}
