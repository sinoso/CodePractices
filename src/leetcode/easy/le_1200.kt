package leetcode.easy

import printResult

fun main() {
    printResult(
        actual = minimumAbsDifference(intArrayOf(4, 2, 1, 3)),
        expected = listOf(listOf(1, 2), listOf(2, 3), listOf(3, 4))
    )
    printResult(
        actual = minimumAbsDifference(intArrayOf(1, 3, 6, 10, 15)),
        expected = listOf(listOf(1, 3))
    )
    printResult(
        actual = minimumAbsDifference(intArrayOf(3, 8, -10, 23, 19, -4, -14, 27)),
        expected = listOf(listOf(-14, -10), listOf(19, 23), listOf(23, 27))
    )
}

private fun minimumAbsDifference(arr: IntArray): List<List<Int>> {
    arr.sort()
    var minimum = Int.MAX_VALUE
    val answerList = mutableListOf<List<Int>>()
    var idx = 1
    val arrSize = arr.size
    var preValue = arr[0]
    var currentDiff: Int

    while (idx < arrSize) {
        currentDiff = arr[idx] - preValue
        when {
            currentDiff > minimum -> {}

            currentDiff == minimum ->
                answerList.add(listOf(preValue, arr[idx]))

            currentDiff < minimum -> {
                answerList.clear()
                minimum = currentDiff
                answerList.add(listOf(preValue, arr[idx]))
            }
        }
        preValue = arr[idx]
        idx++
    }
    return answerList
}

private fun minimumAbsDifference2(arr: IntArray): List<List<Int>> {
    arr.sort()
    var minimum = arr[1] - arr[0]
    val answerList = mutableListOf<List<Int>>()
    answerList.add(listOf(arr[0], arr[1]))
    var idx = 2
    val arrSize = arr.size
    var preValue = arr[1]
    var currentDiff: Int
    
    while (idx < arrSize) {
        currentDiff = arr[idx] - preValue
        when {
            currentDiff > minimum -> {}

            currentDiff == minimum -> {
                answerList.add(listOf(preValue, arr[idx]))
            }

            currentDiff < minimum -> {
                answerList.clear()
                minimum = currentDiff
                answerList.add(listOf(preValue, arr[idx]))
            }
        }
        preValue = arr[idx]
        idx++
    }
    return answerList
}
