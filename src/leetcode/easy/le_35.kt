package leetcode.easy

fun main() {
    println(searchInsert(intArrayOf(-1, 0, 3, 5, 9, 12), target = 13)) //6
    println(searchInsert(intArrayOf(1, 3, 5, 6), 2)) //1
    println(searchInsert(intArrayOf(1, 3, 5, 6), 5)) //2
    println(searchInsert(intArrayOf(1, 3), 2)) //1

}

private fun searchInsert(nums: IntArray, target: Int): Int {
    var front = 0
    var back = nums.lastIndex
    var half:Int
    while (front <= back) {
        half = (front + back) / 2
        if (nums[half] > target) {
            back = half - 1
            continue
        }
        if ((nums[half] < target)) {
            front = half + 1
            continue
        }
        return half
    }
    return front
}