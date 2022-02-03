package leetcode.medium

fun main() {
    println(
        fourSumCount(
            nums1 = intArrayOf(1, 2),
            nums2 = intArrayOf(-2, -1),
            nums3 = intArrayOf(-1, 2),
            nums4 = intArrayOf(0, 2)
        )
    )
    println(
        fourSumCount(
            nums1 = intArrayOf(0),
            nums2 = intArrayOf(0),
            nums3 = intArrayOf(0),
            nums4 = intArrayOf(0)
        )
    )
    println(
        fourSumCount(
            nums1 = intArrayOf(-1, 1, 1, 1, -1),
            nums2 = intArrayOf(0, -1, -1, 0, 1),
            nums3 = intArrayOf(-1, -1, 1, -1, -1),
            nums4 = intArrayOf(0, 1, 0, -1, -1)
        )
    )
}

private fun fourSumCount(nums1: IntArray, nums2: IntArray, nums3: IntArray, nums4: IntArray): Int {
    var answer = 0
    val map = HashMap<Int, Int>()
    for (i in nums1)
        for (j in nums2)
            map[i + j] = map.getOrDefault(i + j, 0) + 1
    for (i in nums3)
        for (j in nums4)
            answer += map.getOrDefault(-(i + j), 0)
    return answer
}
