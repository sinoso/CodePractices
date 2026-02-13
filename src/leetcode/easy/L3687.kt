package leetcode.easy

fun main() {

}

private fun lateFee(daysLate: IntArray): Int {
    var answer = 0
    for (i in daysLate) {
        if (i > 5)
            answer += i * 3
        else if (i > 1)
            answer += i * 2
        else
            answer += i
    }
    return answer
}