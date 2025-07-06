package leetcode.easy

fun main() {
}

private fun countLargestGroup(n: Int): Int {
    val map = HashMap<Int, Int>()
    for (i in 1..n) {
        val key = i.toString().map { it - '0' }.sum()
        map[key] = (map[key] ?: 0) + 1
    }
    val countMap = HashMap<Int, Int>()
    map.entries.forEach {
        countMap[it.value] = (countMap[it.value] ?: 0) + 1
    }
    return countMap.entries.maxBy { it.key }.value
}
