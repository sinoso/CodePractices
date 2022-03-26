package leetcode.medium

import printResult

fun main() {
    printResult(numRescueBoats(intArrayOf(1, 2), 3), 1)
    printResult(numRescueBoats(intArrayOf(3, 2, 2, 1), 3), 3)
    printResult(numRescueBoats(intArrayOf(3, 5, 3, 4), 5), 4)
    printResult(numRescueBoats(intArrayOf(3, 2, 2, 4), 5), 3)
    printResult(numRescueBoats(intArrayOf(2, 2, 2, 4), 5), 3)
}

private fun numRescueBoats(people: IntArray, limit: Int): Int {
    people.sort()
    var count = 0
    var l = 0
    var r = people.lastIndex
    while (l <= r) {
        if (people[l] + people[r] <= limit)
            l++
        r--
        count++
    }
    return count
}
