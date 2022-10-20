package leetcode.medium

fun main() {
    println(spiralOrder(arrayOf(intArrayOf(6, 9, 7))))
    println(spiralOrder(arrayOf(intArrayOf(6), intArrayOf(9), intArrayOf(7))))
    println(spiralOrder(arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))))
    println(spiralOrder(arrayOf(intArrayOf(1, 2, 3, 4), intArrayOf(5, 6, 7, 8), intArrayOf(9, 10, 11, 12))))
    println(
        spiralOrder(
            arrayOf(
                intArrayOf(1, 2, 3, 4),
                intArrayOf(5, 6, 7, 8),
                intArrayOf(9, 10, 11, 12),
                intArrayOf(13, 14, 15, 16)
            )
        )
    )
}

private fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    val new = matrix.map(IntArray::toMutableList).toMutableList()
    val answerList = mutableListOf<Int>()
    while (new.isNotEmpty() && new.first().isNotEmpty()) {
        answerList.addAll(new.removeAt(0))
        if (new.isEmpty()) break
        answerList.addAll(new.map { it.removeAt(it.lastIndex) })
        if (new.isEmpty()) break
        answerList.addAll(new.removeAt(new.lastIndex).reversed())
        if (new.isEmpty() || new.first().isEmpty()) break
        answerList.addAll(new.map { it.removeAt(0) }.reversed())
    }
    return answerList
}
