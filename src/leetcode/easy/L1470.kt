package leetcode.easy

fun main() {
    println(shuffle(intArrayOf(1, 2, 3, 4), 2).contentToString()) //2
}

private fun shuffle(nums: IntArray, n: Int): IntArray {
    val array = IntArray(2 * n) { 0 }
    var idx = 0
    for (i in 0 until n) {
        array[idx++] = nums[i]
        array[idx++] = nums[n + i]
    }
    return array
}
