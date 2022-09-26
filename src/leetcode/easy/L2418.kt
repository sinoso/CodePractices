package leetcode.easy

fun main() {

}

private fun sortPeople(names: Array<String>, heights: IntArray): Array<String> =
    names.withIndex()
        .sortedByDescending { heights[it.index] }
        .map { it.value }
        .toTypedArray()

