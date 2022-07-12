package leetcode.medium

fun main() {

}

fun maxWidthOfVerticalArea(points: Array<IntArray>): Int =
    points.distinctBy { it[0] }
        .sortedWith(compareBy { it[0] })
        .fold(0 to Int.MAX_VALUE) { (largest, lastValue), it ->
            (if (it[0] - lastValue > largest) it[0] - lastValue else largest) to it[0]
        }.first

fun maxWidthOfVerticalArea2(points: Array<IntArray>): Int {
    points.sortWith(compareBy { it[0] })
    var large = 0
    for (i in 1 until points.size) {
        large = large.coerceAtLeast(points[i][0] - points[i - 1][0])
    }
    return large
}

fun maxWidthOfVerticalArea3(points: Array<IntArray>): Int {
    points.sortWith(compareBy { it[0] })
    return points.fold(0 to points[0][0]) { (largest, before), (x, _) ->
        (if (x - before > largest) x - before else largest) to x
    }.first
}
