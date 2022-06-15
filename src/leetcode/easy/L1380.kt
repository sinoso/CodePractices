package leetcode.easy

fun main() {

}

private fun luckyNumbers(matrix: Array<IntArray>): List<Int> {
    val colLastIndex = matrix.first().lastIndex
    val rowLastIndex = matrix.lastIndex
    val luckySet = HashSet<Int>()
    val luckyList = mutableListOf<Int>()
    for (i in 0..rowLastIndex) {
        var max = 100000
        for (j in 0..colLastIndex) {
            max = max.coerceAtMost(matrix[i][j])
        }
        luckySet.add(max)
    }
    for (j in 0..colLastIndex) {
        var min = 0
        for (i in 0..rowLastIndex) {
            min = min.coerceAtLeast(matrix[i][j])
        }
        if(!luckySet.add(min)){
            luckyList.add(min)
        }
    }
    return luckyList
}
