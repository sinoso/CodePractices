package leetcode.medium

import printResult
import java.util.Arrays

fun main() {
    printResult(minProductSum(nums1 = intArrayOf(5, 3, 4, 2), nums2 = intArrayOf(4, 2, 2, 5)), 40)
    printResult(minProductSum(nums1 = intArrayOf(2, 1, 4, 5, 7), nums2 = intArrayOf(3, 2, 4, 8, 6)), 65)
}
private fun minProductSum(nums1: IntArray, nums2: IntArray): Int {
    nums1.sort()
    nums2.sortDescending()
    var index = 0
    val max = nums1.size
    var answer = 0
    while (index < max)
        answer += nums1[index] * nums2[index++]
    return answer
}

private fun minProductSum2(nums1: IntArray, nums2: IntArray): Int =
    (nums1.sorted()).zip(nums2.sortedDescending())
        .fold(0) { acc, (nums1Value, num2Value) -> nums1Value * num2Value + acc }

private fun minProductSum3(nums1: IntArray, nums2: IntArray): Int =
    (nums1.sorted()).zip(nums2.sortedDescending())
        .sumBy { (nums1Value, num2Value) -> nums1Value * num2Value }

private fun minProductSum4(nums1: IntArray, nums2: IntArray): Int {
    Arrays.sort(nums1)
    Arrays.sort(nums2)
    var leftIdx = 0
    var rightIdx = nums1.lastIndex
    val max = nums1.size
    var answer = 0
    while (leftIdx < max)
        answer += nums1[leftIdx++] * nums2[rightIdx--]
    return answer
}
