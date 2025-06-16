package leetcode.easy

fun main() {

}

private fun maximumDifference(nums: IntArray): Int {
    var lastMin = Int.MAX_VALUE
    var diff = -1
    for (i in nums) {
        if (lastMin >= i) {
            lastMin = i
            continue
        }
        diff = diff.coerceAtLeast(i - lastMin)
    }
    return diff
}