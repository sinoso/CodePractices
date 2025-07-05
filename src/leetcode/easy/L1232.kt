package leetcode.easy

fun main() {

}

fun checkStraightLine(coordinates: Array<IntArray>): Boolean {
    //일차함수
    //ay = bx + c
    val (x0, y0) = coordinates[0]
    val (x1, y1) = coordinates[1]
    val dx = x1 - x0
    val dy = y1 - y0

    for (i in 2..coordinates.lastIndex) {
        val (x, y) = coordinates[i]
        if ((x - x0) * dy != (y - y0) * dx)
            return false
    }
    return true
}

