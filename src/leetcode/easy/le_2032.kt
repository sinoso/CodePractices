package leetcode.easy

fun main() {
    println(twoOutOfThree(intArrayOf(1, 1, 3, 2), intArrayOf(2, 3), intArrayOf(3)))
    println(twoOutOfThree(intArrayOf(1, 3), intArrayOf(2, 3), intArrayOf(1, 2)))
}

private fun twoOutOfThree(nums1: IntArray, nums2: IntArray, nums3: IntArray): List<Int> {
    val list = mutableListOf<Int>()
    list.addAll(nums1.toSet())
    list.addAll(nums2.toSet())
    list.addAll(nums3.toSet())
    val mutableMap = mutableMapOf<Int, Int>()
    for (value in list)
        mutableMap[value] = mutableMap.getOrDefault(value, 0) + 1
    return mutableMap.filter { it.value >= 2 }.map { it.key }
}

private fun twoOutOfThree2(nums1: IntArray, nums2: IntArray, nums3: IntArray): List<Int> =
    with(mutableListOf<Int>()) {
        addAll(nums1.toSet())
        addAll(nums2.toSet())
        addAll(nums3.toSet())
        this
    }.groupBy { it }
        .filter { it.value.size >= 2 }
        .keys.toList()

