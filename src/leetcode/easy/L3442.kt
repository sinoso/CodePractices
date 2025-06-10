package leetcode.easy

fun main() {

}

private fun maxDifference(s: String): Int {
    val map = HashMap<Char, Int>()
    for (c in s) {
        map[c] = (map[c] ?: 0) + 1
    }
    val (odd, even) = map.values.partition { it and 1 == 1 }
    val oddMax = odd.max()
    val evenMin = even.min()
    return oddMax - evenMin
}