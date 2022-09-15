package leetcode.medium

import printResult

fun main() {
    printResult(findOriginalArray(intArrayOf(2, 2, 1, 1)), intArrayOf(1, 1))
    printResult(findOriginalArray(intArrayOf(1,3,4,2,6,8)), intArrayOf(1,3,4))
    printResult(findOriginalArray(intArrayOf(5, 8, 7, 8, 16, 5, 16, 14, 10, 10)), intArrayOf(5, 5, 7, 8, 8))
    printResult(findOriginalArray(intArrayOf(4, 4, 16, 20, 8, 8, 2, 10)), intArrayOf(2, 4, 8, 10))
}

// 21:15 ~ 21:57
private fun findOriginalArray(changed: IntArray): IntArray {
    if (changed.size and 1 == 1)
        return intArrayOf()
    changed.sort()
    val arraySize = changed.size shr 1
    val array = IntArray(arraySize)
    var arrayIndex = 0
    val map: HashMap<Int, Int> = HashMap()
    for (i in changed) {
        if (i and 1 == 1) {//odd
            val currentDouble = i shl 1
            if (map[currentDouble] == null || map[currentDouble] == 0) {
                map[i] = (map[i] ?: 0) + 1
            } else {
                map[currentDouble] = map[currentDouble]!! - 1
                array[arrayIndex++] = i
            }
            continue
        }
        //even
        val currentDivided = i shr 1
        if ((map[currentDivided] ?: 0) != 0) {
            map[currentDivided] = map[currentDivided]!! - 1
            array[arrayIndex++] = currentDivided
            continue
        }
        val currentDouble = i shl 1
        if ((map[currentDouble] ?: 0) != 0) {
            map[currentDouble] = map[currentDouble]!! - 1
            array[arrayIndex++] = i
            continue
        }
        map[i] = (map[i] ?: 0) + 1
    }
    return if (arraySize == arrayIndex) array else intArrayOf()
}

