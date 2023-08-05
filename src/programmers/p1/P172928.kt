package programmers.p1

fun main() {
//    solution(arrayOf("SOO", "OOO", "OOO"), arrayOf("E 2", "S 2", "W 1"))
    solution(arrayOf("SOO", "OOO", "XOO"), arrayOf("S 1"))

}

private fun solution(park: Array<String>, routes: Array<String>): IntArray {
    val width = park.first().length
    val height = park.size
    var vertical = width
    var horizontal = height
    for (i in park.indices) {
        for (j in park[i].indices) {
            if (park[i][j] == 'S') {
                vertical = i
                horizontal = j
            }
        }
    }

    fun isVerticalBlocked(range: IntRange) = (range).all { park[it][horizontal] != 'X' }
    fun isHorizontalBlocked(range: IntRange) = (range).all { park[vertical][it] != 'X' }
    for (route in routes) {
        val direction = route[0]
        val step = route[2] - '0'
        when (direction) {
            'N' -> {
                val newVertical = vertical - step
                if (newVertical >= 0 && isVerticalBlocked(newVertical .. vertical)) vertical = newVertical
            }

            'S' -> {
                val newVertical = vertical + step
                if (newVertical < height && isVerticalBlocked(vertical .. newVertical)) vertical = newVertical
            }

            'W' -> {
                val newHorizontal = horizontal - step
                if (newHorizontal >= 0 && isHorizontalBlocked(newHorizontal .. horizontal)) horizontal =
                    newHorizontal
            }

            'E' -> {
                val newHorizontal = horizontal + step
                if (newHorizontal < width && isHorizontalBlocked(horizontal .. newHorizontal)) horizontal =
                    newHorizontal
            }
        }
    }
    return intArrayOf(vertical, horizontal)
}
