package leetcode.easy

fun main() {

}

private fun nearestValidPoint(x: Int, y: Int, points: Array<IntArray>): Int {
    var min = Int.MAX_VALUE
    var index = -1
    for (i in points.indices) {
        if (x == points[i][0]) {
            val dis = Math.abs(y - points[i][1])
            if (dis < min) {
                min = dis
                index = i
            }
        }
        if (y == points[i][1]) {
            val dis = Math.abs(x - points[i][0])
            if (dis < min) {
                min = dis
                index = i
            }
        }
    }
    return index
}