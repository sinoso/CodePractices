package leetcode.medium

import printResult

fun main() {
    printResult(maximumSwap(2736), 7236)
//    printResult(maximumSwap(9973),9973)
}

fun maximumSwap(num: Int): Int {
    val numArray = num.toString().toCharArray()
    val map = hashMapOf<Char, MutableList<Int>>()
    var index = numArray.lastIndex
    while (index >= 0) {
        map[numArray[index]] = (map[numArray[index]] ?: mutableListOf()).apply { add(index) }
        index--
    }
    for (i in numArray.indices) {
        for (key in '9' downTo numArray[i] + 1) {
            val valueList = map[key] ?: continue
            if (valueList.first() < i)
                continue
            val temp = numArray[valueList.first()]
            numArray[valueList.first()] = numArray[i]
            numArray[i] = temp
            return String(numArray).toInt()
        }
    }
    return num
}
