package programmers


fun main() {
    println(solution(intArrayOf(4, 7, 12), booleanArrayOf(true, false, true)))
}

private fun solution(absolutes: IntArray, signs: BooleanArray): Int = absolutes.mapIndexed { idx, i -> if (signs[idx]) i else i * -1 }.sum()
