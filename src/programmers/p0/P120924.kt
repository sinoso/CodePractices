package programmers.p0

fun main() {

}

private fun solution(common: IntArray): Int {
    if (common.size == 2)
        return 2 * common[1] - common[0]
    val diff1 = common[0] - common[1]
    val diff2 = common[1] - common[2]
    if (diff1 == diff2)
        return common.last() + diff1
    else
        return common.last() * common[2] / common[1]
}
