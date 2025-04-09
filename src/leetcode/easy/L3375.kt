package leetcode.easy

fun main() {

}

private fun minOperations(nums: IntArray, k: Int): Int {
    val sorted = nums.toSet().sorted()
    if (sorted.first() < k)
        return -1
    return sorted.count { it > k }
}
