package leetcode.medium

fun main() {
    println(subarraySum(intArrayOf(1, 1, 1), 2).also { if (it == 2) print("pass ") else print("fail ") })
    println(subarraySum(intArrayOf(1, 2, 3), 3).also { if (it == 2) print("pass ") else print("fail ") })
    println(subarraySum(intArrayOf(1, 2, 3), 1).also { if (it == 1) print("pass ") else print("fail ") })
    println(subarraySum(intArrayOf(0, 0, 0, 0), 0).also { if (it == 10) print("pass ") else print("fail ") })
    println(subarraySum(intArrayOf(0), 0).also { if (it == 1) print("pass ") else print("fail ") })
    println(subarraySum(intArrayOf(-1, -1, 1), 0).also { if (it == 1) print("pass ") else print("fail ") })
}


fun subarraySum(nums: IntArray, k: Int): Int {
    var count = 0
    val map = HashMap<Int, Int>()
    map[nums[0]] = 1
    if (nums[0] == k)
        count++
    for (i in 1..nums.lastIndex) {
        nums[i] += nums[i - 1]
        count += map.getOrDefault(nums[i] - k, 0)
        map[nums[i]] = map.getOrDefault(nums[i], 0) + 1
        if (nums[i] == k)
            count++
    }
    return count
}
