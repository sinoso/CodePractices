package leetcode.easy

fun main() {

}

private fun countKDifference(nums: IntArray, k: Int): Int {
    val table = Array(101) { 0 }
    for (i in nums)
        table[i]++
    var count = 0
    val end = 100 - k
    for (i in 1..end) {
        if (table[i + k] != 0) {
            count += table[i] * table[i + k]
        }
    }
    return count
}
