package leetcode.easy

fun main() {

}

private fun findChampion(grid: Array<IntArray>): Int {
    var maxIndex = 0
    var maxValue = 0
    for (i in grid.indices) {
        val count = grid[i].count { it == 1 }
        if (maxValue < count) {
            maxIndex = i
            maxValue = count
        }
    }
    return maxIndex
}