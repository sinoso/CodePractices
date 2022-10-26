package programmers

fun main() {
    solution(intArrayOf(1, 2, 3, 4, 5))
}

private fun solution(number: IntArray): Int =
    (0..number.lastIndex - 2).map { i ->
        ((i + 1)..number.lastIndex - 1).map { j ->
            ((j + 1)..number.lastIndex).map { k -> number[i] + number[j] + number[k] }
                .count { it == 0 }
        }.sum()
    }.sum()

private fun solution2(number: IntArray): Int {
    var answer = 0
    val lastIndex = number.lastIndex
    for (i in 0..lastIndex - 2) {
        for (j in (i + 1)..lastIndex - 1) {
            for (k in (j + 1)..lastIndex) {
                if (number[i] + number[j] + number[k] == 0)
                    answer++
            }
        }
    }
    return answer
}
