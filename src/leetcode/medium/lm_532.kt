package leetcode.medium

fun main() {
    println(findPairs(nums = intArrayOf(3, 1, 4, 1, 5), k = 2))//2
    println(findPairs(nums = intArrayOf(1, 2, 3, 4, 5), k = 1))//4
    println(findPairs(nums = intArrayOf(1, 3, 1, 5, 4), k = 0))//1
}

private fun findPairs(nums: IntArray, k: Int): Int {
    val map = hashMapOf<Int, Boolean>()
    var count = 0
    for (i in nums) {
        if (map[i] != null) {
            if (map[i] == true && k == 0)
                count++
            map[i] = false
        } else {
            if (map[i - k] != null)
                count++
            if (map[i + k] != null)
                count++
            map[i] = true
        }
    }
    return count
}

private fun findPairs2(nums: IntArray, k: Int): Int {
    val numbers = hashSetOf<Int>()
    val found = hashSetOf<Int>()
    for (i in nums) {
        if (numbers.contains(i + k)) found.add(i)
        if (numbers.contains(i - k)) found.add(i - k)
        numbers.add(i)
    }
    return found.size
}
