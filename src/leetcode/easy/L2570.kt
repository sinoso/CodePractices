package leetcode.easy

fun main() {
    mergeArrays(
        arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(4, 5)),
        arrayOf(intArrayOf(1, 4), intArrayOf(3, 2), intArrayOf(4, 1))
    )
}

private fun mergeArrays(nums1: Array<IntArray>, nums2: Array<IntArray>): Array<IntArray> {
    val table = IntArray(nums1.last()[0].coerceAtLeast(nums2.last()[0]) + 1)
    for ((k, v) in nums1) {
        table[k] += v
    }
    for ((k, v) in nums2) {
        table[k] += v
    }
    val answer = ArrayList<IntArray>(table.count { it != 0 })
    for (i in table.indices) {
        if (table[i] != 0) {
            answer.add(intArrayOf(i, table[i]))
        }
    }
    return answer.toTypedArray()
}

private fun mergeArrays2(nums1: Array<IntArray>, nums2: Array<IntArray>): Array<IntArray> {
    val map = HashMap<Int, Int>()
    nums1.forEach { (key, value) ->
        map[key] = (map[key] ?: 0) + value
    }
    nums2.forEach { (key, value) ->
        map[key] = (map[key] ?: 0) + value
    }
    return map.entries.sortedBy { it.key }.map { intArrayOf(it.key, it.value) }.toTypedArray()
}