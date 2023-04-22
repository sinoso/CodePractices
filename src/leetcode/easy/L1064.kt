package leetcode.easy

import printResult


fun main() {
    printResult(fixedPoint(intArrayOf(-10, -5, 0, 3, 7)), 3)
    printResult(fixedPoint(intArrayOf(0, 2, 5, 8, 17)), 0)
    printResult(fixedPoint(intArrayOf(-10, -5, 3, 4, 7, 9)), -1)
}


private fun fixedPoint(arr: IntArray): Int {
    var answer = -1
    val fullSize = arr.size
    for (idx in arr.indices) {
        if (idx == arr[idx]) {
            answer = idx
            break
        }
        if (fullSize < arr[idx])
            break
    }
    return answer
}
