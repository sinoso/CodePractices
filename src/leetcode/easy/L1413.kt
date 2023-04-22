package leetcode.easy

fun main() {
    println(minStartValue(intArrayOf(-3, 2, -3, 4, 2)))
    println(minStartValue(intArrayOf(1, 2)))
    println(minStartValue(intArrayOf(1, 2)))
    println(minStartValue(intArrayOf(-3, 2, -3, 4, 2)))
}

private fun minStartValue(nums: IntArray): Int {
        var answer = 1
        var currentValue = 1
        for (num in nums) {
            currentValue += num
            if (currentValue <= 0) {
                answer += 1 - currentValue
                currentValue = 1
            }
        }
        return answer
}

private fun minStartValue2(nums: IntArray): Int {
    val lastIdx = nums.indexOfLast { it < 0 }
    if (lastIdx == -1)
        return 1
    var answer = 1
    var currentValue = 1
    for (idx in 0..lastIdx) {
        val sum = currentValue + nums[idx]
        if (sum <= 0) {
            answer += -sum + 1
            currentValue = 1
            continue
        }
        currentValue = sum
    }
    return answer
}
