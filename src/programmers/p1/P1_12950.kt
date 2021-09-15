package programmers

import tools.PrintArray

fun main() {
    PrintArray.printArray2(solution(arrayOf(intArrayOf(1, 2), intArrayOf(2, 3)), arrayOf(intArrayOf(3, 4), intArrayOf(5, 6))))
}

private fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> =
        arr1.also { it.forEachIndexed { index1, ints -> ints.forEachIndexed { index2, _ -> it[index1][index2] += arr2[index1][index2] } } }