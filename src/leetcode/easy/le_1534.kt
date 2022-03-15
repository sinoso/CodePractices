package leetcode.easy

import printResult

fun main() {
   printResult(countGoodTriplets(intArrayOf(3, 0, 1, 1, 9, 7), 7, 2, 3),4)
   printResult(countGoodTriplets(intArrayOf(1, 1, 2, 2, 3), 0, 0, 1),0)
}

private fun countGoodTriplets(arr: IntArray, a: Int, b: Int, c: Int): Int {
    var answer = 0
    for (i in 0..(arr.lastIndex - 2)) {
        for (j in i + 1 until arr.lastIndex) {
            if (Math.abs(arr[i] - arr[j]) <= a)
                for (k in j + 1..arr.lastIndex) {
                    if (Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
                        answer++
                    }
                }
        }
    }
    return answer
}
