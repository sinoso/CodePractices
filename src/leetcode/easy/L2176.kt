package leetcode.easy

fun main() {
//    countPairs(intArrayOf(3,1,2,2,2,1,3),2)
    countPairs(intArrayOf(10, 2, 3, 4, 9, 6, 3, 10, 3, 6, 3, 9, 1), 4)
}

private fun countPairs(nums: IntArray, k: Int): Int {
    val lastIndex = nums.lastIndex
    var answer = 0
    for (i in 0 until lastIndex) {
        for (j in (i + 1)..lastIndex) {
            if (nums[i] == nums[j] && (i * j) % k == 0)
                answer++
        }
    }
    return answer
}

private fun countPairs2(nums: IntArray, k: Int): Int {
    val map = HashMap<Int, MutableList<Int>>()
    for (i in nums.indices) {
        map[nums[i]] = (map[nums[i]] ?: mutableListOf()).apply { add(i) }
    }
    var answer = 0
    for (entry in map.entries) {
        val list = entry.value
        if (list.size == 1)
            continue
        val lastIndex = list.lastIndex
        for (i in 0 until lastIndex) {
            if (list[i] % k == 0) {
                answer += lastIndex - i
                continue
            }
            for (j in (i + 1)..lastIndex) {
                if ((list[i] * list[j]) % k == 0)
                    answer++
            }
        }
    }
    return answer
}
