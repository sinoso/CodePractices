package leetcode.medium


fun main() {
//    minimumHealth(intArrayOf(2,7,4,3),4)
    minimumHealth(intArrayOf(2, 5, 3, 4), 7)
}

private fun minimumHealth(damage: IntArray, armor: Int): Long {
    var answer = 0L
    var greatest = 0
    for (i in damage) {
        if (greatest < i) {
            answer += greatest
            greatest = i
            continue
        }
        answer += i
    }
    answer += (greatest - armor).coerceAtLeast(0)

    return answer + 1
}
