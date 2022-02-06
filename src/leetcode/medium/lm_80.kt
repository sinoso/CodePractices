package leetcode.medium

fun main() {
    val checker: (IntArray) -> Unit = { array ->
        removeDuplicates(array).also {
            println(it)
            println(array.take(it).joinToString())
        }
    }
    checker(intArrayOf(1, 1, 1, 2, 2, 3))
    checker(intArrayOf(1))
}

private fun removeDuplicates(nums: IntArray): Int {
    var count = 0
    var lastValue = -10001
    var isCheckedValue = true
    for (currentValue in nums)
        if (lastValue != currentValue || !isCheckedValue) {
            isCheckedValue = lastValue == currentValue
            lastValue = currentValue
            nums[count++] = currentValue
        }
    return count
}

private fun removeDuplicates3(nums: IntArray): Int {
    var count = 0
    var lastValue = -10001
    var leftIdx = 0
    var isCheckedValue = true
    for (idx in nums.indices) {
        val currentValue = nums[idx]
        if (lastValue == currentValue) {
            if (!isCheckedValue) {
                count++
                lastValue = currentValue
                nums[leftIdx++] = currentValue
                isCheckedValue = true
            }
            continue
        }
        if (lastValue != currentValue) {
            count++
            lastValue = currentValue
            nums[leftIdx++] = currentValue
            isCheckedValue = false
        }
    }
    return count
}
