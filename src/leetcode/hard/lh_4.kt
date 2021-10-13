package leetcode.hard

fun main() {
    println(findMedianSortedArrays(intArrayOf(1, 3), intArrayOf(2)))
    println(findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(3, 4)))
    println(findMedianSortedArrays(intArrayOf(0, 0), intArrayOf(0, 0)))
    println(findMedianSortedArrays(intArrayOf(), intArrayOf(1)))
    println(findMedianSortedArrays(intArrayOf(2), intArrayOf()))
    println(findMedianSortedArrays(intArrayOf(), intArrayOf(2, 3)))
}

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val totalSize = nums1.size + nums2.size
    val targetIdx = (totalSize) / 2
    var currentIdx = 0
    var currentValue = 0
    var lastValue = 0
    var nums1Idx = 0
    var nums2Idx = 0
    while (currentIdx++ <= targetIdx) {
        lastValue = currentValue
        if (nums1Idx < nums1.size && nums2Idx < nums2.size) {
            if (nums1[nums1Idx] > nums2[nums2Idx]) {
                currentValue = nums2[nums2Idx++]
                continue
            }
            currentValue = nums1[nums1Idx++]
            continue
        }
        if (nums2Idx == nums2.size) {
            currentValue = nums1[nums1Idx++]
            continue
        }
        currentValue = nums2[nums2Idx++]
    }
    if (totalSize and 1 == 1) // totalSize is even
        return currentValue.toDouble()
    return (currentValue + lastValue) / 2.0
}

fun findMedianSortedArrays2(nums1: IntArray, nums2: IntArray): Double {
    val newNums = (nums1 + nums2).sorted()
    if ((newNums.lastIndex and 1) == 1) {//짝수
        val idx = newNums.lastIndex / 2
        return (newNums[idx] + newNums[idx + 1]) / (2).toDouble()
    }
    //홀수
    return newNums[newNums.lastIndex / 2].toDouble()
}