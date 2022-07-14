package leetcode.medium

fun main() {
    val array = intArrayOf(1,1,3,2,1)
    nextPermutation(array)
    println(array.joinToString(","))
}

private fun nextPermutation(nums: IntArray): Unit {
    //find ascending point
    //input types
    //1. last
    //2. middle
    //3. first
    var changePoint = nums.lastIndex
    while (changePoint > 0) {
        if (nums[changePoint] > nums[changePoint - 1]) {
            break
        }
        changePoint--
    }
    if (changePoint == 0) {// all descending Permutation == last : next Permutation is first
        nums.sort()
        return
    }
    // find nextLargerThen this
    var nextLargeValueIndex = changePoint
    for (i in changePoint..nums.lastIndex) {
        if (nums[i] < nums[nextLargeValueIndex] && nums[i] > nums[changePoint - 1])
            nextLargeValueIndex = i
    }
    val temp = nums[nextLargeValueIndex]
    nums[nextLargeValueIndex] = nums[changePoint - 1]
    nums[changePoint - 1] = temp
    //sort
    for (value in (changePoint..nums.lastIndex).map { nums[it] }.sorted()){
        nums[changePoint++] = value
    }
}
