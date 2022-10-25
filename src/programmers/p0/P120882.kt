package programmers.p0


fun main() {
    solution(arrayOf(intArrayOf(80,70),intArrayOf(90,50),intArrayOf(40,70),intArrayOf(80,50),))
}

private fun solution(score: Array<IntArray>): IntArray {
    val map = hashMapOf<Int, MutableList<Int>>()
    val answer = IntArray(score.size)
    score.withIndex()
        .forEach { (index, value) ->
            map[value.sum()] = (map[value.sum()] ?: mutableListOf()).apply { add(index) }
        }
    var grade = 1
    for (entry in map.entries.sortedByDescending { it.key }) {
        entry.value.forEach {
            answer[it] = grade
        }
        grade += entry.value.size
    }
    return answer
}
