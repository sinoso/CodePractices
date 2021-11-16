package leetcode.easy

fun main() {
    val array1 = intArrayOf(1, 2, 3, 7, 8, 0)
    merge(array1, 3, intArrayOf(2, 5, 6), 3)
    println(array1.joinToString())
    val array2 = intArrayOf(1)
    merge(array2, 1, intArrayOf(), 0)
    println(array2.joinToString())
    val array3 = intArrayOf(0, 0, 0)
    merge(array3, 0, intArrayOf(1, 2, 3), 3)
    println(array3.joinToString())
}

private fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var left = m - 1
    var right = n - 1
    for (idx in n + m - 1 downTo 0)
        when {
            left < 0 -> nums1[idx] = nums2[right--]
            right < 0 -> nums1[idx] = nums1[left--]
            nums1[left] > nums2[right] -> nums1[idx] = nums1[left--]
            else -> nums1[idx] = nums2[right--]
        }
}

private fun merge2(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var left = m - 1
    var right = n - 1
    var idx = n + m - 1
    while (right >= 0) {
        if (left < 0)
            while (right >= 0)
                nums1[idx--] = nums2[right--]
        else if (nums1[left] > nums2[right])
            nums1[idx--] = nums1[left--]
        else
            nums1[idx--] = nums2[right--]
    }
}

private fun merge3(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    with(nums2.slice(0 until n).toMutableList()) {
        addAll(nums1.slice(0 until m))
        sort()
        forEachIndexed { index, i -> nums1[index] = i }
    }
}

private fun merge4(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    for (i in 0 until n)
        nums1[m + i] = nums2[i]
    nums1.sort()
}
