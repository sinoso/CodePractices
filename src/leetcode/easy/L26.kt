package leetcode.easy

fun main() {
    var array = intArrayOf(1, 1, 2)
    println(removeDuplicates(array))
    println(array.contentToString())
    var array2 = intArrayOf()
    println(removeDuplicates(array2))
    println(array2.contentToString())
}

private fun removeDuplicates(nums: IntArray): Int {
    var left = 0
    val set = mutableSetOf<Int>()
    for (right in nums.indices)
        if (set.add(nums[right]))
            nums[left++] = nums[right]
    return left
}
