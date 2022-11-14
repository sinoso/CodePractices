package leetcode.easy

fun main() {
    findPoisonedDuration(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9), 1)
}

private fun findPoisonedDuration(timeSeries: IntArray, duration: Int): Int {
    var answer = 0
    var last = 0
    for (i in timeSeries) {
        if (last > i) {
            answer += i + duration - last
            last = i + duration
        } else {
            answer += duration
            last = i + duration
        }
    }
    return answer
}
//1 4 - 2
// 1 2  3
//       4 5
