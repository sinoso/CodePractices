package leetcode.easy

fun main() {
    println(findCenter(arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(4, 2))))
}

private fun findCenter(edges: Array<IntArray>): Int {
    val map = mutableMapOf<Int, MutableSet<Int>>()
    edges.forEach {
        map[it[0]] = map.getOrDefault(it[0], mutableSetOf()).apply {
            this.add(it[1])
        }
        map[it[1]] = map.getOrDefault(it[1], mutableSetOf()).apply {
            this.add(it[0])
        }
    }
    return map.maxBy { it.value.size }!!.key
}
private fun findCenter2(edges: Array<IntArray>): Int {
    val map = mutableMapOf<Int, MutableSet<Int>>()
    edges.forEach {
        map[it[0]] = map.getOrDefault(it[0], mutableSetOf()).apply {
            this.add(it[1])
        }
        map[it[1]] = map.getOrDefault(it[1], mutableSetOf()).apply {
            this.add(it[0])
        }
    }
    return map.maxByOrNull { it.value.size }!!.key
}
