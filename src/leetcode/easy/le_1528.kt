package leetcode.easy

fun main() {
    println(restoreString("codeleet", intArrayOf(4, 5, 6, 7, 0, 2, 1, 3)))
    println(restoreString("aiohn", intArrayOf(3, 1, 4, 2, 0)))
}

private fun restoreString(s: String, indices: IntArray): String =
    String(CharArray(indices.size).apply { indices.forEachIndexed { index, i -> this[i] = s[index] } })


private fun restoreString2(s: String, indices: IntArray): String =
    s.withIndex().sortedBy { indices[it.index] }.map { it.value }.joinToString("")
