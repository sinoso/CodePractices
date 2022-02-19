package leetcode.easy

import printResult

fun main() {
    printResult(actual = peakIndexInMountainArray(intArrayOf(0, 1, 0)), expected = 1)
    printResult(actual = peakIndexInMountainArray(intArrayOf(0, 2, 1, 0)), expected = 1)
    printResult(actual = peakIndexInMountainArray(intArrayOf(0, 10, 5, 2)), expected = 1)
    printResult(actual = peakIndexInMountainArray(intArrayOf(0, 10, 15, 2)), expected = 2)
}

private fun peakIndexInMountainArray(arr: IntArray): Int {
    var left = 0
    var right = arr.lastIndex
    while (left < right) {
        val pivot = (left + right) / 2
        if (arr[pivot] < arr[pivot + 1])
            left = pivot + 1
        else
            right = pivot
    }
    return right
}

private fun peakIndexInMountainArray2(arr: IntArray): Int {
    var idx = 0
    while (arr[idx] < arr[idx + 1])
        idx++
    return idx
}
