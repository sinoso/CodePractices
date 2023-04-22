package leetcode.easy

fun main() {
    println(nextGreaterElement(intArrayOf(4, 1, 2), intArrayOf(1, 3, 4, 2)).joinToString())
}

fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
    val map = HashMap<Int, Int>()
    nums2.forEachIndexed { index, i -> map[i] = index }
    return nums1.map { value -> (map[value]!!..nums2.lastIndex).find { value < nums2[it] }?.let {idx-> nums2[idx] } ?:-1 }.toIntArray()
}
