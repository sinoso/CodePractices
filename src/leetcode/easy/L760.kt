package leetcode.easy

fun main() {

}

private fun anagramMappings(nums1: IntArray, nums2: IntArray): IntArray = nums1.map { nums2.indexOf(it) }.toIntArray()

