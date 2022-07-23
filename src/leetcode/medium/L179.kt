package leetcode.medium

import printResult

fun main() {
    printResult(largestNumber(intArrayOf(3, 30, 34, 5, 9)), "9534330")
}

private fun largestNumber(nums: IntArray): String {
    val list = nums.map<String> { it.toString() }
        .sortedWith(Comparator { o1: String, o2: String -> -(o1 + o2).compareTo(o2 + o1) })
    if (list.first()=="0")
        return "0"
    else
        return list.joinToString("")
}
