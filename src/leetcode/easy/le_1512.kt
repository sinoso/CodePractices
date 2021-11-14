package leetcode.easy

fun main() {
    println(numIdenticalPairs(intArrayOf(1, 2, 3, 1, 1, 3)))
    println(numIdenticalPairs(intArrayOf(1, 1, 1, 1)))
}

private fun numIdenticalPairs(nums: IntArray): Int {
    var count = 0
    for(i in 0 until nums.lastIndex)
        for(j in (i+1)..nums.lastIndex)
            if(nums[i]==nums[j]) count++
    return count
}

private fun numIdenticalPairs2(nums: IntArray): Int {
    var answer = 0
    for (i in 0 until nums.lastIndex)
        for (j in (i + 1)..nums.lastIndex)
            if (nums[i] == nums[j])
                answer++
    return answer
}

private fun numIdenticalPairs3(nums: IntArray): Int =
    nums.groupBy { it }.map { (0 until it.value.size).sum() }.sum()

