package leetcode.easy

fun main() {

}

private fun largestUniqueNumber(nums: IntArray): Int {
    val map = HashMap<Int, Int>()
    map[-1] = 1
    for (i in nums) {
        map[i] = (map[i] ?: 0) + 1
    }
    return map.entries.filter { it.value == 1 }.maxOf { it.key }
}