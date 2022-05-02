package leetcode.medium

fun main() {

}

class SubrectangleQueries(private val rectangle: Array<IntArray>) {

    fun updateSubrectangle(row1: Int, col1: Int, row2: Int, col2: Int, newValue: Int) {
        for (row in row1..row2)
            for (col in col1..col2)
                rectangle[row][col] = newValue
    }

    fun getValue(row: Int, col: Int) = rectangle[row][col]

}
