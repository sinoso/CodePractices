package leetcode.easy

import tools.checkResult

fun main() {
    checkResult(
        expected = listOf(listOf(1, 3), listOf(4, 6)),
        actual = findDifference(nums1 = intArrayOf(1, 2, 3), nums2 = intArrayOf(2, 4, 6))
    )
    checkResult(
        expected = listOf(listOf(3), listOf()),
        actual = findDifference(nums1 = intArrayOf(1, 2, 3, 3), nums2 = intArrayOf(1, 1, 2, 2))
    )
}

private fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
    val set1 = nums1.toSet()
    val set2 = nums2.toSet()
    return listOf(set1.filter { !set2.contains(it) }, set2.filter { !set1.contains(it) })
}