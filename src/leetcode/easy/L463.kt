package leetcode.easy

fun main() {

}

private fun islandPerimeter(grid: Array<IntArray>): Int {
    var sum = 0
    for (i in grid.indices) {
        for (j in grid.first().indices) {
            sum += checker(grid, i, j)
        }
    }
    return sum
}

private fun checker(grid: Array<IntArray>, row: Int, col: Int): Int {
    if (grid[row][col] == 0)
        return 0
    var count = 0
    if (row == grid.lastIndex || grid[row + 1][col] == 0)
        count++
    if (row == 0 || grid[row - 1][col] == 0)
        count++
    if (col == 0 || grid[row][col - 1] == 0)
        count++
    if (col == grid.first().lastIndex || grid[row][col + 1] == 0)
        count++
    return count
}
