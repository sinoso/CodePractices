package leetcode.easy

import kotlin.math.sqrt


fun main() {

}

private fun constructRectangle(area: Int): IntArray {
    val mid = sqrt(area.toFloat())
    if ((mid - mid.toInt()) == 0f)
        return intArrayOf(mid.toInt(), mid.toInt())
    var left = mid.toInt()
    while (left < area) {
        if (area % left == 0) {
            val right = area / left
            return intArrayOf(left.coerceAtLeast(right), left.coerceAtMost(right))
        }
        left++
    }
    return intArrayOf(area, 1)
}