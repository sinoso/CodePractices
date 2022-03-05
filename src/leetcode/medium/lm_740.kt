package leetcode.medium

import printResult

fun main() {
    printResult(deleteAndEarn(intArrayOf(3, 4, 2)), 6)
    printResult(deleteAndEarn(intArrayOf(2, 2, 3, 3, 3, 4)), 9)
    printResult(deleteAndEarn(intArrayOf(1, 1, 2, 2, 3)), 5) //2-1, 4-2, 3-3
    printResult(deleteAndEarn(intArrayOf(10, 10, 10, 9, 9, 9, 9, 9, 8, 8, 8, 7, 7, 7, 7, 7, 7, 6, 6, 6, 6, 6, 6, 5, 5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1)), 138)
    printResult(deleteAndEarn(intArrayOf(1, 1, 1, 2, 4, 5, 5, 5, 6)), 18)

}

private fun deleteAndEarn(nums: IntArray): Int {
    val map = HashMap<Int, Int>()
    var maxNum = 0
    nums.forEach {
        map[it] = (map[it] ?: 0) + it
        maxNum = maxNum.coerceAtLeast(it)
    }
    var temp: Int
    var back = map[1] ?: 0
    var back2 = map[0] ?: 0
    var idx = 2
    while (idx < maxNum + 1) {
        temp = back
        back = ((map[idx] ?: 0) + back2).coerceAtLeast(back)
        back2 = temp
        idx++
    }
    return back
}
