package leetcode.easy

fun main() {
    println(smallerNumbersThanCurrent(intArrayOf(8, 1, 2, 2, 3)).joinToString())
    println(smallerNumbersThanCurrent(intArrayOf(6, 5, 4, 8)).joinToString())
    println(smallerNumbersThanCurrent(intArrayOf(7, 7, 7, 7)).joinToString())
    println(smallerNumbersThanCurrent(intArrayOf(7, 7, 7, 7, 8)).joinToString())
}

private fun smallerNumbersThanCurrent(nums: IntArray): IntArray =
    IntArray(nums.size) { index -> nums.count { nums[index] > it } }

private fun smallerNumbersThanCurrent2(nums: IntArray): IntArray {
    val sortedIndex = List(nums.size) { it }.sortedBy { nums[it] }
    val answer = IntArray(nums.size)
    answer[sortedIndex[0]] = 0
    var count = 1
    for (idx in 1..sortedIndex.lastIndex) {
        if (nums[sortedIndex[idx]] == nums[sortedIndex[idx - 1]]) {
            answer[sortedIndex[idx]] = answer[sortedIndex[idx - 1]]
            count++
            continue
        }
        answer[sortedIndex[idx]] = count++
    }
    return answer
}
