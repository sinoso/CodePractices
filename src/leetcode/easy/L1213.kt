package leetcode.easy

fun main() {

}

private fun arraysIntersection(arr1: IntArray, arr2: IntArray, arr3: IntArray): List<Int> {
    val map = LinkedHashMap<Int, Int>()
    arr1.forEach {
        map[it] = (map[it] ?: 0) + 1
    }
    arr2.forEach {
        map[it] = (map[it] ?: 0) + 1
    }
    arr3.forEach {
        map[it] = (map[it] ?: 0) + 1
    }
    return map.entries.filter { it.value == 3 }.map { it.key }
}

private fun arraysIntersection2(arr1: IntArray, arr2: IntArray, arr3: IntArray): List<Int> {
    val set = arr1.toMutableSet()
    val set2 = arr2.toMutableSet()
    return arr3.filter { set.contains(it) && set2.contains(it) }
}
