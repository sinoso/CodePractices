package leetcode.easy

fun main() {

}

private fun shiftGrid(grid: Array<IntArray>, k: Int): List<List<Int>> {
    val rowSize = grid[0].size
    val fullSize = grid.size * rowSize
    val refineK = k % fullSize
    return List(grid.size) { i ->
        val currentRowIdx = rowSize * i
        List(rowSize) { j ->
            val idx = (fullSize - refineK + currentRowIdx + j) % fullSize
            grid[idx / rowSize][idx % rowSize]
        }
    }
}
