package leetcode.easy

fun main() {
    minimumOperations(intArrayOf(1, 2, 3, 4, 2, 3, 3, 5, 7))
}

private fun minimumOperations(nums: IntArray): Int {
    var count = 0
    val set = HashSet<Int>()
    for (list in nums.toList().chunked(3).reversed()) {
        val isDuplicated = list
            .fold(false) { acc, i -> !set.add(i) || acc }
        if (isDuplicated)
            break
        count++
    }
    return (nums.size + 3 - 1) / 3 - count
}