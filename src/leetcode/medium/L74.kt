package leetcode.medium

fun main() {
    val result =
        searchMatrix(arrayOf(intArrayOf(1, 3, 5, 7), intArrayOf(10, 11, 16, 20), intArrayOf(23, 30, 34, 60)), 13)
//    val result2 = searchMatrix(arrayOf(intArrayOf(1)),1)
//    println(result2)

}

private fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    val width = matrix[0].size
    val height = matrix.size
    var left = 0
    var right = width * height - 1
    while (left <= right) {
        val mid = (left + right) / 2
        val midValue = matrix[mid / width][mid % width]
        if (midValue == target)
            return true
        if (target < midValue) {
            right = mid - 1
            continue
        }
            left = mid + 1
    }
    return false
}