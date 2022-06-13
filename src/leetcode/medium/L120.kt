package leetcode.medium


fun main() {

}

private fun minimumTotal(triangle: List<List<Int>>): Int {
    val mTriangle = MutableList(triangle.size) { triangle[it].toMutableList() }
    for (i in 1..triangle.lastIndex) {
        val lastIndex = triangle[i].lastIndex
        for (j in 1 until lastIndex) {
            if (mTriangle[i - 1][j] > mTriangle[i - 1][j - 1]) {
                mTriangle[i][j] += mTriangle[i - 1][j - 1]
            } else {
                mTriangle[i][j] += mTriangle[i - 1][j]
            }
        }
        mTriangle[i][0] += mTriangle[i - 1].first()
        mTriangle[i][lastIndex] += mTriangle[i - 1].last()
    }
    return mTriangle.last().fold(Int.MAX_VALUE) { acc, i -> acc.coerceAtMost(i) }
}
