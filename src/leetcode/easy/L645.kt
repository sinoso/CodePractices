package leetcode.easy

fun main() {
    findErrorNums(intArrayOf(1,2,2,4))
}

private fun findErrorNums(nums: IntArray): IntArray {
    val lookUpTable = IntArray(nums.size + 1)
    for (i in nums) {
        lookUpTable[i]++
    }
    var errorNumber = 0
    var notInclude = 0
    for (index in 1..nums.size) {
        if (lookUpTable[index] == 1)
            continue
        if (lookUpTable[index] == 2)
            errorNumber = index
        if (lookUpTable[index] == 0)
            notInclude = index
    }
    return intArrayOf(errorNumber, notInclude)
}

private fun findErrorNums2(nums: IntArray): IntArray {
    val set = HashSet<Int>()
    var errorNumber = 0
    var notInclude = 0
    for (i in nums) {
        if (!set.add(i)) {
            errorNumber = i
        }
    }
    for (i in 1..nums.size) {
        if (!set.contains(i)) {
            notInclude = i
        }
    }
    return intArrayOf(errorNumber, notInclude)
}
