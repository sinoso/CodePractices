package leetcode.easy

fun main() {

}

private fun minCostToMoveChips(position: IntArray): Int {
    var odd = 0
    var even = 0
    for (i in position) {
        if (i % 2 == 0) even++
        else odd++
    }
    return even.coerceAtMost(odd)
}