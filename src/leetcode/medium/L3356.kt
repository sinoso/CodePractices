package leetcode.medium

import printResult


fun main() {
    printResult(
        actual = minZeroArray(
            nums = intArrayOf(1, 0, 6),
            queries = arrayOf(
                intArrayOf(1, 2, 1),
                intArrayOf(0, 0, 4),
                intArrayOf(1, 1, 5),
                intArrayOf(0, 0, 5),
                intArrayOf(1, 2, 4),
                intArrayOf(0, 2, 2),
                intArrayOf(2, 2, 4),
                intArrayOf(1, 2, 2),
                intArrayOf(1, 2, 4),
                intArrayOf(0, 1, 3)
            )
        ),
        expected = 6
    )
    printResult(
        actual = minZeroArray(
            nums = intArrayOf(2, 0, 2),
            queries = arrayOf(intArrayOf(0, 2, 1), intArrayOf(0, 2, 1), intArrayOf(1, 1, 3))
        ),
        expected = 2
    )
    printResult(
        actual = minZeroArray(
            nums = intArrayOf(4, 3, 2, 1),
            queries = arrayOf(intArrayOf(1, 3, 2), intArrayOf(0, 2, 1))
        ),
        expected = -1
    )
    printResult(
        actual = minZeroArray(
            nums = intArrayOf(4, 3, 2, 1),
            queries = arrayOf(intArrayOf(1, 3, 2), intArrayOf(0, 2, 1))
        ),
        expected = -1
    )
}

private fun minZeroArray(nums: IntArray, queries: Array<IntArray>): Int {
    //nums to diffArray
    var firstPositiveIndex = nums.indexOfFirst { it != 0 }
    val lastIndex = nums.lastIndex
    for (i in nums.lastIndex downTo 1) {
        nums[i] -= nums[i - 1]
    }

    var count = 0
    if (firstPositiveIndex == -1)
        return 0

    for ((left: Int, right: Int, value: Int) in queries) {
        //check Is finished
        if (firstPositiveIndex > lastIndex)
            return count

        //calculate value
        count++
        if (right < firstPositiveIndex)
            continue
        nums[left.coerceAtLeast(firstPositiveIndex)] -= value
        if (right < lastIndex) {
            nums[right + 1] += value
        }
        //moveIndex
        var lastValue = nums[firstPositiveIndex]
        while (lastValue <= 0) {
            firstPositiveIndex++
            if (firstPositiveIndex > lastIndex)
                break
            lastValue += nums[firstPositiveIndex]
            nums[firstPositiveIndex] = lastValue
        }
    }
    //check Result
    if (firstPositiveIndex <= lastIndex)
        return -1
    return count
}
