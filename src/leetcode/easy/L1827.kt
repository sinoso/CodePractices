package leetcode.easy

fun main() {
    minOperations(intArrayOf(1, 5, 2, 4, 1))
}

private fun minOperations(nums: IntArray): Int {
    var lastValue = 0
    var answer = 0
    for (i in nums) {
        if (i > lastValue) {
            lastValue = i
            continue
        }
        val needToUp = lastValue - i + 1
        answer += needToUp
        lastValue = i + needToUp
    }
    return answer
}