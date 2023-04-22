package leetcode.easy

fun main() {
    println(sortedSquares(intArrayOf(-4, -1, 0, 3, 10)).contentToString())
}


fun sortedSquares(nums: IntArray): IntArray {
    var array = IntArray(nums.size)
    var pointF = 0
    var pointB = nums.lastIndex
    for(i in nums.lastIndex downTo 0) {
        if (nums[pointF] * nums[pointF] < nums[pointB] * nums[pointB]) {
            array[i] = nums[pointB] * nums[pointB--]
            continue
        }
        array[i] = nums[pointF] * nums[pointF++]
    }
    return array
}

fun sortedSquares2(nums: IntArray): IntArray = nums.map { it * it }.sorted().toIntArray()
fun sortedSquares3(nums: IntArray): IntArray {
    for (i in nums.indices) {
        nums[i] = nums[i] * nums[i]
    }
    nums.sort()
    return nums
}