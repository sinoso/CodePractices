package leetcode.easy

import java.util.PriorityQueue

fun main() {
}

fun kWeakestRows(mat: Array<IntArray>, k: Int): IntArray {
    val priorityQueue = PriorityQueue(compareBy<IndexedValue<Int>> { it.value }.thenBy { it.index })
    for (i in mat.indices) {
        val sum = mat[i].fold(0) { acc, int -> acc + int }
        priorityQueue.add(IndexedValue(i, sum))
    }
    return IntArray(k){priorityQueue.poll().index}
}

fun kWeakestRows2(mat: Array<IntArray>, k: Int): IntArray =
    mat.withIndex()
        .map { it.index to (it.value.reduce { acc, i -> acc + i }) }
        .sortedWith(compareBy<Pair<Int, Int>> { it.second }.thenBy { it.first })
        .take(k)
        .map { it.first }
        .toIntArray()