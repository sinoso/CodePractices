package leetcode.medium

fun main() {
    sortColors(intArrayOf(2,0,2,1,1,0))
    sortColors(intArrayOf(2,0,1))
}

private fun sortColors(nums: IntArray): Unit {
    var point2 = nums.lastIndex
    var point0 = 0
    for (point1 in nums.indices) {
        while (point1 != 1 || (point1 < point2 || point0 < point1)) {
            if (nums[point1] == 0 && point0 < point1) {
                nums[point1] = nums[point0]
                nums[point0++] = 0
            }
           else if (nums[point1] == 2 && point1 < point2) {
                nums[point1] = nums[point2]
                nums[point2--] = 2
            }
            else
                break
        }
    }
}
