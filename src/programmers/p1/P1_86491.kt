package programmers.p1


fun main() {
println(solution(arrayOf(intArrayOf(1,2))))
}
private fun solution(sizes: Array<IntArray>): Int {
    var max = 0
    var max2 = 0
    sizes.forEach {
        max = it[0].coerceAtLeast(it[1]).coerceAtLeast(max)
        max2 = it[0].coerceAtMost(it[1]).coerceAtLeast(max2)
    }
    return max * max2
}