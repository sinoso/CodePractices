package leetcode.medium

import printResult

fun main() {
    printResult(
        sumEvenAfterQueries(
            intArrayOf(1, 2, 3, 4),
            arrayOf(intArrayOf(1, 0), intArrayOf(-3, 1), intArrayOf(-4, 0), intArrayOf(2, 3))
        ),
        intArrayOf(8, 6, 2, 4)
    )
}


private fun sumEvenAfterQueries(nums: IntArray, queries: Array<IntArray>): IntArray {
    fun Int.isEven() = this and 1 == 0
    var sum = nums.filter(Int::isEven).sum()

    val answer = IntArray(queries.size) {
        val (value, targetIndex) = queries[it]
        if (nums[targetIndex].isEven()) {
            sum -= nums[targetIndex]
        }
        nums[targetIndex] += value
        if (nums[targetIndex].isEven()) {
            sum += nums[targetIndex]
        }
        return@IntArray sum
    }

    return answer
}

// 13:22 ~ 13:47
private fun sumEvenAfterQueries2(nums: IntArray, queries: Array<IntArray>): IntArray {
    var sum = nums.filter { it and 1 == 0 }.sum()

    val answer = IntArray(queries.size) {
        val (value, targetIndex) = queries[it]
        //odd
        if (nums[targetIndex] and 1 == 1) {
            nums[targetIndex] += value
            if (nums[targetIndex] and 1 == 0) {
                sum += nums[targetIndex]
            }
            return@IntArray sum
        }
        //even
        sum -= nums[targetIndex]
        nums[targetIndex] += value
        if (nums[targetIndex] and 1 == 0) {
            sum += nums[targetIndex]
        }
        sum
    }
    return answer
}

//1. 처음 값이 홀수 일시
//1-1 계산후 짝수가 되면 변경된 값을 더한다.
//1-2 계산후 여전히 홀수면 더하지 않는다.

//2. 처음 값이 짝수 일시
//2-1 기존값을 뺀다.
//2-2 계산 후 값이 짝수 라면 변경 값을 더한다.

