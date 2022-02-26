package leetcode.easy

import printResult

fun main() {
    printResult(findShortestSubArray(intArrayOf(1, 2, 2, 3, 1)), 2)
    printResult(findShortestSubArray(intArrayOf(1, 2, 2, 3, 1, 4, 2)), 6)
}

private fun findShortestSubArray(nums: IntArray): Int {
    val map = HashMap<Int, Array<Int>>()
    var maxSize = 0
    nums.forEachIndexed { index, i ->
        val array = map.getOrDefault(i, Array(3) { 0 }.apply {
            this[1] = index
        })
        array[0]++
        maxSize = maxSize.coerceAtLeast(array[0])
        array[2] = index
        map[i] = array
    }
    return map.values.filter { it[0] == maxSize }
        .fold(50_000) { acc, array -> acc.coerceAtMost(array[2] - array[1] + 1) }
}

private fun findShortestSubArray2(nums: IntArray): Int {
    val map = HashMap<Int, MutableList<Int>>()
    var maxSize = 0
    nums.forEachIndexed { index, i ->
        map[i] =
            map.getOrDefault(i, mutableListOf())
                .apply { add(index) }
                .also { maxSize = it.size.coerceAtLeast(maxSize) }
    }
    return map.values.filter { it.size == maxSize }
        .fold(50_000) { acc, list -> acc.coerceAtMost(list.last() - list.first() + 1) }
}
