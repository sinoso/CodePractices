package leetcode.medium

import printResult


fun main() {
    printResult(findArray(intArrayOf(5, 2, 0, 3, 1)), intArrayOf(5, 7, 2, 3, 2))
    printResult(findArray(intArrayOf(13)), intArrayOf(13))
}


private fun findArray(pref: IntArray): IntArray {
    var pre = pref.first()
    var current: Int
    for (i in 1..pref.lastIndex) {
        current = pref[i]
        pref[i] = pre xor pref[i]
        pre = current
    }
    return pref
}


private fun findArray2(pref: IntArray): IntArray {
    val answer = IntArray(pref.size)
    answer[0] = pref.first()
    for (i in 1..pref.lastIndex) {
        answer[i] = pref[i - 1] xor pref[i]
    }
    return answer
}
//5,2,0,3,1 input
//5,7,2,3,2   result
//  0
//  1
