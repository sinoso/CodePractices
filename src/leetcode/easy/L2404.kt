package leetcode.easy

fun main() {
}

private fun mostFrequentEven(nums: IntArray): Int {
    val hashMap = HashMap<Int, Int>()
    for (i in nums) {
        if (i and 1 == 0) {
            hashMap[i] = (hashMap[i] ?: 0) + 1
        }
    }
    var maxCount = 0
    var minKey = Int.MAX_VALUE
    for ((key, value) in hashMap) {
        if (maxCount < value) {
            maxCount = value
            minKey = key
            continue
        }
        if (maxCount == value && key < minKey)
            minKey = key
    }
    return if (maxCount == 0) -1 else minKey
}