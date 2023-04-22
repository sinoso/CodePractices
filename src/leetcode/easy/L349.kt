package leetcode.easy

fun main() {
    println(intersection(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2)).joinToString(","))//2
    println(intersection(intArrayOf(9, 4, 9, 8, 4), intArrayOf(4, 9)).joinToString(","))//9 4
    println(intersection(intArrayOf(), intArrayOf()).joinToString(","))//9 4
}

private fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    val set1 = nums1.toHashSet()
    val set2 = hashSetOf<Int>()
    nums2.forEach { if(set1.contains(it)) set2.add(it) }
    return set2.toIntArray()
}

private fun intersection2(nums1: IntArray, nums2: IntArray): IntArray {
    val set1 = nums1.toHashSet()
    val set2 = nums2.toHashSet()
    val largeSet: HashSet<Int>
    val smallSet: HashSet<Int>
    if (set1.size > set2.size) {
        largeSet = set1
        smallSet = set2
    } else {
        largeSet = set2
        smallSet = set1
    }
   return smallSet.filter { largeSet.contains(it) }.toIntArray()
}
