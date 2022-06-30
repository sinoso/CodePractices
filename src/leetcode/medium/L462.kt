package leetcode.medium

import printResult

fun main() {
    printResult(minMoves2(intArrayOf(1, 2, 3)), 2)
    printResult(minMoves2(intArrayOf(1, 10, 2, 9)), 16)
}

fun minMoves2(nums: IntArray): Int =
    nums.sort().run { nums.fold(0) { acc, i -> acc + Math.abs((nums[nums.size / 2] - i)) } }


fun minMoves2_2(nums: IntArray): Int {
    nums.sort()
    var answer = 0
    val median = nums[nums.size / 2]
    for (i in nums) {
        val moves = median - i
        answer += if (moves > 0) moves else -moves
    }
    return answer
}
//fun minMoves2(nums: IntArray): Int {
//    val average = Math.round(nums.average()).toInt()
//    return nums.fold(0) { acc, i ->
//        var temp = average - i
//        if (temp < 0)
//            temp *= -1
//        acc + temp
//    }
//}
