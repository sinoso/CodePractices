package leetcode.easy

import printResult

fun main() {
    printResult(sumOddLengthSubarrays(intArrayOf(1, 4, 2, 5, 3)), 58)
    printResult(sumOddLengthSubarrays(intArrayOf(1, 2)), 3)
    printResult(sumOddLengthSubarrays(intArrayOf(10, 11, 12)), 66)

}

private fun sumOddLengthSubarrays(arr: IntArray): Int {
    var size = 1
    var sum = 0
    val lastIndex = arr.lastIndex
    val arrSize = arr.size
    while (size <= arrSize) {
        for (i in 0..(lastIndex - size + 1)) {
            for (j in i until i + size)
                sum += arr[j]
        }
        size += 2
    }
    return sum
}
