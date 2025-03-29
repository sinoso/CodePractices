package leetcode.easy

fun main() {

}

private fun maxCount(m: Int, n: Int, ops: Array<IntArray>): Int {
    var minM = m
    var minN = n
    for ((opM, opN) in ops) {
        if (minM > opM) minM = opM
        if (minN > opN) minN = opN
    }
    return minM * minN
}
