package leetcode.medium

fun main() {

}

private fun minPathSum(grid: Array<IntArray>): Int {

    for (j in 1..grid.first().lastIndex) {
        grid[0][j] += grid[0][j - 1]
    }
    for (i in 1..grid.lastIndex) {
        grid[i][0] += grid[i - 1][0]
    }
    val jRange = 1..grid.first().lastIndex
    for (i in 1..grid.lastIndex) {
        for (j in jRange) {
            grid[i][j] += if (grid[i - 1][j] < grid[i][j - 1]) grid[i - 1][j] else grid[i][j - 1]
        }
    }
    return grid.last().last()
}
