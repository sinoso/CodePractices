package leetcode.easy

fun main() {

}

private fun findPeaks(mountain: IntArray): List<Int> {
    val answer = mutableListOf<Int>()
    for (i in 1 until mountain.lastIndex) {
        if (mountain[i - 1] < mountain[i] && mountain[i] > mountain[i + 1])
            answer.add(i)
    }
    return answer
}