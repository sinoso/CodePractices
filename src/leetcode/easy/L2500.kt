package leetcode.easy

fun main() {

}

private fun deleteGreatestValue(grid: Array<IntArray>): Int {
    grid.forEach(IntArray::sortDescending)
    var sum = 0
    for (i in grid.first().indices) {
        var max = 0
        for (j in grid.indices) {
            max = max.coerceAtLeast(grid[j][i])
        }
        sum += max
    }
    return sum
}