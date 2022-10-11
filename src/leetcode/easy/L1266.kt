package leetcode.easy

fun main() {
}

fun minTimeToVisitAllPoints(points: Array<IntArray>): Int {
    var pre = points.first()
    var answer = 0
    for (index in 1..points.lastIndex) {
        val (preX, preY) = pre
        val (currentX, currentY) = points[index]
        fun abs(i: Int) = if (i < 0) i * -1 else i
        val xDiff = abs(preX - currentX)
        val yDiff = abs(preY - currentY)
        answer += xDiff.coerceAtLeast(yDiff)
        pre = points[index]
    }
    return answer
}
