package leetcode.medium

fun main() {
    matrixBlockSum(arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9)), 1)
}

// 13:31 ~ 14:00
private fun matrixBlockSum(mat: Array<IntArray>, k: Int): Array<IntArray> {
    val height: Int = mat.size
    val width: Int = mat[0].size
    val preFixed: Array<IntArray> = Array(height) { IntArray(width) }
    for (i in mat.indices) {
        preFixed[i][0] = mat[i][0]
        for (j in 1 until width) {
            preFixed[i][j] = preFixed[i][j - 1] + mat[i][j]
        }
    }
    // startIndex i-k ~ i+k endIndex 일때 각각의 값은 0이상이여야 하며 width보다 작아야한다.
    // startIndex j-k ~ j+k endIndex 일때 각각의 값은 0이상이여야 하며 height보다 작아야한다.
    val maxHeightIndex: Int = height - 1
    val maxWidthIndex: Int = width - 1
    val answer: Array<IntArray> = Array(height) { i ->
        val heightRange = (i - k).coerceAtLeast(0)..(i + k).coerceAtMost(maxHeightIndex)
        IntArray(width) { j ->
            var sum = 0
            val widthStart = (j - k).coerceAtLeast(0)
            val widthEnd = (j + k).coerceAtMost(maxWidthIndex)
            for (r in heightRange) {
                sum += preFixed[r][widthEnd]
                if (widthStart != 0) {
                    sum -= preFixed[r][widthStart - 1]
                }
            }
            sum
        }
    }
    return answer
}
