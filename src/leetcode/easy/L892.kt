package leetcode.easy


fun main() {
    surfaceArea(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)))
}

private fun surfaceArea(grid: Array<IntArray>): Int {
    var answer = 0
    for (i in grid.indices) {
        for (j in grid.first().indices) {
            var currentArea = 0
            //y+
            val yPlusDiff = grid[i][j] - if (i == 0) 0 else grid[i - 1][j]
            if (yPlusDiff > 0)
                currentArea += yPlusDiff
            //y-
            val yMinusDiff = grid[i][j] - if (i == grid.lastIndex) 0 else grid[i + 1][j]
            if (yMinusDiff > 0)
                currentArea += yMinusDiff
            //x+
            val xPlusDiff = grid[i][j] - if (j == grid.lastIndex) 0 else grid[i][j + 1]
            if (xPlusDiff > 0)
                currentArea += xPlusDiff
            //x-
            val xMinusDiff = grid[i][j] - if (j == 0) 0 else grid[i][j - 1]
            if (xMinusDiff > 0)
                currentArea += xMinusDiff
            val zDiff = if (grid[i][j] == 0) 0 else 2
            currentArea += zDiff
            answer += currentArea
        }
    }
    return answer
}