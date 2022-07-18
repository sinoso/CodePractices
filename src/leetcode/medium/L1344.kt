package leetcode.medium

fun main() {

}


private fun angleClock(hour: Int, minutes: Int): Double {
    var answer: Double = minutes * 5.5 - hour * 30.0
    if (answer < 0)
        answer *= -1
    if (answer > 180)
        return 360 - answer
    else
        return answer
}
