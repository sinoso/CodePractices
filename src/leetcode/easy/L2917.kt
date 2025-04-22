package leetcode.easy

fun main() {
    findKOr(intArrayOf(14, 7, 12, 9, 8, 9, 1, 15), k = 4)
}

private fun findKOr(nums: IntArray, k: Int): Int {
    val map = HashMap<Int, Int>()
    for (num in nums) {
        var left = num
        var bitPos = 0
        do {
            map[bitPos] = (map[bitPos] ?: 0) + (left and 1)
            bitPos++
            left = left shr 1
        } while (left > 0)
    }
    return map.entries
        .sortedByDescending { it.key }
        .fold(initial = 0) { acc, (_, value) ->
            (acc shl 1) + (if (value >= k) 1 else 0)
        }
}
