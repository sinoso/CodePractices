package programmers.p0

fun main() {

}

private fun solution(emergency: IntArray): IntArray = emergency.apply {
    withIndex().sortedByDescending { it.value }.forEachIndexed { priorityIndex, (index, _) ->
        emergency[index] = priorityIndex + 1
    }
}
