package leetcode.medium

fun main() {

}

private fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    val m = matrix[0].size
    val n = matrix.size
    for(i in 0 until n)
        if(matrix[i][0]<=target && target<=matrix[i][m-1]) {
            for (j in 0 until m)
                if(matrix[i][j]==target)
                    return true
            break
        }
    return false
}
