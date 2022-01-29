package leetcode.medium

fun main() {
    val arrays = arrayOf(
        charArrayOf('1', '1', '1', '1', '0'),
        charArrayOf('1', '1', '0', '1', '0'),
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('0', '0', '0', '0', '0')
    )
    println(numIslands(arrays))
}

private fun numIslands(grid: Array<CharArray>): Int {
    var answer = 0
    for (y in grid.indices) {
        for (x in grid[y].indices) {
            if (grid[y][x] == '0')
                continue
            answer++
            searchAndChange(x, y, grid)
        }
    }
    return answer
}

private fun searchAndChange(x: Int, y: Int, grid: Array<CharArray>) {
    println("$y $x")
    if (grid[y][x] == '0')
        return
    grid[y][x] = '0'
    if (x != grid[0].lastIndex)
        searchAndChange(x + 1, y, grid)
    if (x != 0)
        searchAndChange(x - 1, y, grid)
    if (y != grid.lastIndex)
        searchAndChange(x, y + 1, grid)
    if (y != 0)
        searchAndChange(x, y - 1, grid)
}
