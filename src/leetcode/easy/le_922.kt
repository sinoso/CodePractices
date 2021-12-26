package leetcode.easy


fun main() {
    println(sortArrayByParityII(intArrayOf(4, 2, 5, 7)).joinToString(","))
    println(sortArrayByParityII(intArrayOf(4, 2, 3, 3,3,4)).joinToString(","))
    println(sortArrayByParityII(intArrayOf(2, 3)).joinToString(","))
    println(sortArrayByParityII(intArrayOf(3, 2)).joinToString(","))
}

private fun sortArrayByParityII(nums: IntArray): IntArray {
    var oddIdx = 1
    var evenIdx = 0

    while (oddIdx < nums.size) {
        if (nums[oddIdx] and 1 == 1) {
            oddIdx += 2
            continue
        }
        if (nums[evenIdx] and 1 != 1) {
            evenIdx += 2
            continue
        }
        nums[evenIdx] = nums[evenIdx] xor nums[oddIdx]
        nums[oddIdx] = nums[evenIdx] xor nums[oddIdx]
        nums[evenIdx] = nums[evenIdx] xor nums[oddIdx]
    }
    return nums
}
