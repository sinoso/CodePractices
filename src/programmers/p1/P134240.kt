package programmers.p1

fun main() {
}

private fun solution(food: IntArray): String {
    val sb = StringBuilder()
    for (i in 1..food.lastIndex) {
        repeat(food[i] / 2) { sb.append(i) }
    }
    val reversed = sb.reversed()
    sb.append(0)
    sb.append(reversed)
    return sb.toString()
}
