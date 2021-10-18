package programmers

fun main() {
    println(solution(intArrayOf(1, 2, 3, 4, 5)).contentToString())
    println(solution(intArrayOf(1, 3, 2, 4, 2)).contentToString())
}

private fun solution(answers: IntArray): IntArray {
    var answer = IntArray(3)
    val supojas = arrayOf(intArrayOf(1, 2, 3, 4, 5), intArrayOf(2, 1, 2, 3, 2, 4, 2, 5), intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5))
    for (i in answers.indices) {
        for (j in supojas.indices) {
            if (answers[i] == supojas[j][i % supojas[j].size]) {
                answer[j]++
            }
        }
    }
    return supojas.indices.filter { v -> answer[v] == answer.maxOrNull() }.map { v -> v + 1 }.toIntArray()
}
