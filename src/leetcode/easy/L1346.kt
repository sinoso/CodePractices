package leetcode.easy

import tools.checkResult

fun main() {
    checkResult(expected = true, actual = checkIfExist(intArrayOf(10, 2, 5, 3)))
    checkResult(expected = false, actual = checkIfExist(intArrayOf(3, 1, 7, 11)))
    checkResult(expected = false, actual = checkIfExist(intArrayOf(4, -7, 11, 4, 18)))
}

private fun checkIfExist(arr: IntArray): Boolean {
    val map = HashMap<Int, Int>()
    for (i in arr) {
        val valueExist = map[i] ?: 0
        if (valueExist == 2)
            return true
        val doubled = map[i * 2] ?: 0
        if (doubled == 1)
            return true
        map[i * 2] = 2
        map[i] = 1
    }
    return false
}
