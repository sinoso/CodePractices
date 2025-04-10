package leetcode.easy

import leetcode.testclass.ListNode

fun main() {

}

private fun rowAndMaximumOnes(mat: Array<IntArray>): IntArray {
    var lastMax = -1
    var lastMaxIndex = 0
    for (i in mat.indices) {
        var count = 0
        for (j in mat[i].indices) {
            count += mat[i][j]
        }
        if (lastMax < count) {
            lastMax = count
            lastMaxIndex = i
        }
    }
    return intArrayOf(lastMaxIndex, lastMax)
}