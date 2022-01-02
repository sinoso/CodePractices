package leetcode.medium

fun main() {
    println(numPairsDivisibleBy60(intArrayOf(30, 20, 150, 100, 40)))
    println(numPairsDivisibleBy60(intArrayOf(60, 60, 60)))
}

private fun numPairsDivisibleBy60(time: IntArray): Int {
    val timesMap = HashMap<Int, Int>()
    var answer = 0
    time.forEach {
        val currentLeftDividedBy60 = it % 60
        val currentNeedValue = (60 - currentLeftDividedBy60) % 60
        timesMap[currentNeedValue]?.let { numberOfTimes -> answer += numberOfTimes }
        timesMap[currentLeftDividedBy60] = timesMap.getOrDefault(key = currentLeftDividedBy60, defaultValue = 0) + 1
    }
    return answer
}
