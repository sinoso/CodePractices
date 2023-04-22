package leetcode.easy

fun main() {
//    println(twoSum(intArrayOf(2, 7, 11, 15), 9).contentToString()) //6
//    println(twoSum(intArrayOf(3, 2, 4), 6).contentToString()) //1
//    println(twoSum(intArrayOf(3, 3), 6).contentToString()) //2
    println(twoSum(intArrayOf(0, 4, 3, 0), 0).contentToString()) //2


}

private fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()
    for ((index, num) in nums.withIndex())
        if (map.containsKey(target - num))
            return intArrayOf(index, map[target - num]!!)
        else
            map[num] = index
    return intArrayOf()
}

private fun twoSum2(nums: IntArray, target: Int): IntArray {
    var newList = nums.indices.sortedWith(compareBy { v -> nums[v] })
    var left = 0
    var right = newList.lastIndex
    var flag = true
    while (flag && left < right) {
        val sum = nums[newList[left]] + nums[newList[right]]
        when {
            sum == target ->
                flag = false
            sum < target ->
                left++
            sum > target ->
                right--
        }
    }
    return intArrayOf(newList[left], newList[right])
}
