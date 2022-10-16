package leetcode.easy


fun main() {

}

fun largestLocal(grid: Array<IntArray>): Array<IntArray> =
    Array(grid.size - 2) { x ->
        IntArray(grid.size - 2) { y ->
            (0..2).map { xAdd ->
                (0..2).map { yAdd -> grid[x + xAdd][y + yAdd] }.reduce { acc, i -> acc.coerceAtLeast(i) }
            }.reduce { acc, i -> acc.coerceAtLeast(i) }
        }
    }
