package leetcode.easy

import printResult


fun main() {
    printResult(findMissingRanges(intArrayOf(0, 1, 3, 50, 75), 0, 99), listOf("2", "4->49", "51->74", "76->99"))
    printResult(findMissingRanges(intArrayOf(-1), -1, -1), listOf())
}

private fun findMissingRanges(nums: IntArray, lower: Int, upper: Int): List<String> {
    val makeRange: (start: Int, end: Int) -> String = { start, end -> if (start != end) "$start->$end" else "$start" }
    val rangeList = mutableListOf<String>()
    var lastValue = lower - 1
    for (i in nums) {
        if (i - lastValue > 1)
            rangeList.add(makeRange(lastValue + 1, i - 1))
        lastValue = i
    }
    if (upper != lastValue)
        rangeList.add(makeRange(lastValue + 1, upper))
    return rangeList
}

private fun findMissingRanges2(nums: IntArray, lower: Int, upper: Int): List<String> {
    var lastValue = lower - 1
    val rangeList = ArrayList<Pair<Int, Int>>()
    for (i in nums) {
        if (i - lastValue < 2) {
            lastValue = i
            continue
        }
        rangeList.add(lastValue + 1 to i - 1)
        lastValue = i
    }
    if (upper != lastValue)
        rangeList.add(lastValue + 1 to upper)
    return rangeList.map { (start: Int, end: Int) -> if (start != end) "$start->$end" else "$start" }
}
