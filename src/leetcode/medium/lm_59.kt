package leetcode.medium

fun main() {
    println(generateMatrix(5).joinToString { it.joinToString(",") + "\n" })
}

private fun generateMatrix(n: Int): Array<IntArray> {
    val array = Array(n) { IntArray(n) }
    var count = 1
    val max = n * n
    var colStart = 0
    var colEnd = n - 1
    var rowStart = 0
    var rowEnd = n - 1
    var col = 0
    var row = 0
    var idx = 0
    while (count <= max) {
        idx = rowStart
        while (idx <= rowEnd)
            array[col][idx++] = count++
        row = rowEnd
        colStart++

        idx = colStart
        while (idx <= colEnd)
            array[idx++][row] = count++
        col = colEnd
        rowEnd--

        idx = rowEnd
        while (idx >= rowStart)
            array[col][idx--] = count++
        colEnd--
        row = rowStart

        idx = colEnd
        while (idx >= colStart)
            array[idx--][row] = count++
        rowStart++
        col = colStart
    }
    return array
}

private fun generateMatrix2(n: Int): Array<IntArray> {
    val array = Array(n) { IntArray(n) }
    var count = 1
    val max = n * n
    var colStart = 0
    var colEnd = n - 1
    var rowStart = 0
    var rowEnd = n - 1
    var col = 0
    var row = 0
    while (count <= max) {
        for (i in rowStart..rowEnd)
            array[col][i] = count++
        row = rowEnd
        colStart++
        for (i in colStart..colEnd)
            array[i][row] = count++
        col = colEnd
        rowEnd--
        for (i in rowEnd downTo rowStart)
            array[col][i] = count++
        colEnd--
        row = rowStart
        for (i in colEnd downTo colStart)
            array[i][row] = count++
        rowStart++
        col = colStart
    }
    return array
}
