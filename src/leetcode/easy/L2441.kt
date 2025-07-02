package leetcode.easy

import kotlin.math.absoluteValue

fun main() {

}

private fun findMaxK(nums: IntArray): Int {
    var lastMax = -1
    val set = HashSet<Int>()
    for (i in nums) {
        set.add(i)
        if (set.contains(-i)) {
            lastMax = lastMax.coerceAtLeast(i.absoluteValue)
        }
    }
    return lastMax
}