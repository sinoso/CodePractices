package programmers

//프로그래머스 위클리 챌린지
fun main() {
    println(solution(arrayOf(intArrayOf(50, 90), intArrayOf(50, 87))))
    println(solution(arrayOf(intArrayOf(70, 49, 90), intArrayOf(68, 50, 38), intArrayOf(73, 31, 100))))
}

private fun solution(scores: Array<IntArray>): String {
    return scores.mapIndexed { index, ints ->
        var flag = 0
        var list = arrayListOf<Int>().also { (scores.indices).map { v -> it.add(scores[v][index]) } }
        list.forEach { if (it == ints[index]) flag++ }
        if ((list.maxOrNull() == ints[index] || list.minOrNull() == ints[index]) && flag == 1)
            list.remove(ints[index])
        list.average()
    }.joinToString("") {
        when {
            it >= 90 -> "A"
            it >= 80 -> "B"
            it >= 70 -> "C"
            it >= 50 -> "D"
            else -> "F"
        }
    }
}