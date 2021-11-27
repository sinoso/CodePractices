package leetcode.medium

fun main() {
    val array = arrayOf(
        charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
        charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
        charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
        charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
        charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
        charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
        charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
        charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
        charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
    )
    println(isValidSudoku(array))

    val array2 = arrayOf(
        charArrayOf('8', '3', '.', '.', '7', '.', '.', '.', '.'),
        charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
        charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
        charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
        charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
        charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
        charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
        charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
        charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
    )
    println(isValidSudoku(array2))

    val array3 = arrayOf(
        charArrayOf('.', '4', '.', '.', '.', '.', '.', '.', '.'),
        charArrayOf('.', '.', '4', '.', '.', '.', '.', '.', '.'),
        charArrayOf('.', '.', '.', '1', '.', '.', '7', '.', '.'),
        charArrayOf('.', '.', '.', '.', '.', '.', '.', '.', '.'),
        charArrayOf('.', '.', '.', '3', '.', '.', '.', '6', '.'),
        charArrayOf('.', '.', '.', '.', '.', '6', '.', '9', '.'),
        charArrayOf('.', '.', '.', '.', '1', '.', '.', '.', '.'),
        charArrayOf('.', '.', '.', '.', '.', '.', '2', '.', '.'),
        charArrayOf('.', '.', '.', '8', '.', '.', '.', '.', '.')
    )
    println(isValidSudoku(array3))

    val array4 = arrayOf(charArrayOf('.', '.', '.', '.', '.', '.', '.', '.', '2')
        ,charArrayOf('.', '.', '.', '.', '.', '.', '6', '.', '.')
        ,charArrayOf('.', '.', '1', '4', '.', '.', '8', '.', '.')
        ,charArrayOf('.', '.', '.', '.', '.', '.', '.', '.', '.')
        ,charArrayOf('.', '.', '.', '.', '.', '.', '.', '.', '.')
        ,charArrayOf('.', '.', '.', '.', '3', '.', '.', '.', '.')
        ,charArrayOf('5', '.', '8', '6', '.', '.', '.', '.', '.')
        ,charArrayOf('.', '9', '.', '.', '.', '.', '4', '.', '.')
        ,charArrayOf('.', '.', '.', '.', '5', '.', '.', '.', '.'))
    println(isValidSudoku(array4))

}

private fun isValidSudoku(board: Array<CharArray>): Boolean {
    val grids = HashMap<Int, HashSet<Char>>()
    val columns = HashMap<Int, HashSet<Char>>()
    board.forEachIndexed { indexOfRow, chars ->
        val row = HashSet<Char>()
        chars.forEachIndexed { indexOfColumns, c ->
            if (c == '.')
                return@forEachIndexed
            if (!(columns[indexOfColumns] ?: hashSetOf<Char>().also { columns[indexOfColumns] = it }).add(c))
                return false
            val gridKey = indexOfRow / 3 * 10 + indexOfColumns / 3
            if (!(grids[gridKey] ?: hashSetOf<Char>().also { grids[gridKey] = it }).add(c))
                return false
            if (!row.add(c))
                return false
        }
    }
    return true
}
