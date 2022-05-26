package leetcode.easy

fun main() {

}

private fun largestAltitude(gain: IntArray): Int {
    var max = 0
    var current = 0
    for (i in gain) {
        current += i
        max = max.coerceAtLeast(current)
    }
    return max
}
