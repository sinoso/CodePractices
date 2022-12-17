package programmers.p0

fun main() {

}

private fun solution(dots: Array<IntArray>): Int {
    if (gradient(dots[0], dots[1]) == gradient(dots[2], dots[3]))
        return 1
    if (gradient(dots[0], dots[2]) == gradient(dots[1], dots[3]))
        return 1
    if (gradient(dots[0], dots[3]) == gradient(dots[1], dots[2]))
        return 1
    return 0
}
fun gradient(dot1: IntArray, dot2: IntArray): Double {
    val (dot1x, dot1y) = dot1
    val (dot2x, dot2y) = dot2
    return (dot1x - dot2x).toDouble() / (dot1y - dot2y)
}
