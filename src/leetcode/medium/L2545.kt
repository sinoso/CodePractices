package leetcode.medium

fun main() {

}

private fun sortTheStudents(score: Array<IntArray>, k: Int): Array<IntArray> =
    score.apply { sortByDescending { it[k] } }
