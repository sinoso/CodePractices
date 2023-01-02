package leetcode.medium

fun main() {
    println(
        equalPairs(
            arrayOf(
                intArrayOf(3, 1, 2, 2),
                intArrayOf(1, 4, 4, 5),
                intArrayOf(2, 4, 2, 2),
                intArrayOf(2, 4, 2, 2)
            )
        )
    )
}

private fun equalPairs(grid: Array<IntArray>): Int {
    val map = HashMap<String, Int>()
    grid.forEach {
        val s = it.joinToString("|")
        map[s] =  (map[s] ?: 0) + 1
    }
    var answer = 0
    for (i in grid.indices) {
        val s = grid.indices.joinToString("|") { j -> grid[j][i].toString() }
        if (map.contains(s)) {
            answer += map[s]!!
        }
    }
    return answer
}

