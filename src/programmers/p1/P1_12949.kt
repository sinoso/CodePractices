package programmers

import tools.PrintArray

fun main() {
    PrintArray.printArray2(solution(arrayOf(intArrayOf(1, 4), intArrayOf(3, 2), intArrayOf(4, 1)), arrayOf(intArrayOf(3, 3), intArrayOf(3, 3))))
}

private fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
    val array1Length = arr1.size
    val array2Length: Int = arr2[0].size
    val answer = Array(array1Length) { IntArray(array2Length) }
    for (i in 0 until array1Length) {
        for (j in 0 until array2Length) {
            var elementValue = 0
            val subArray = arr1[i]
            val subArrayLength = subArray.size
            for (k in 0 until subArrayLength) {
                elementValue += subArray[k] * arr2[k][j]
            }
            answer[i][j] = elementValue
        }
    }
    return answer
}
