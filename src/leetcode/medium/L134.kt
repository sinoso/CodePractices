package leetcode.medium


fun main() {

}

private fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
    var total = 0
    var current = 0
    var startIndex = 0
    for (i in gas.indices) {
        total += gas[i] - cost[i]
        current += gas[i] - cost[i]
        if (current < 0) {
            startIndex = i + 1
            current = 0
        }
    }
    if (total < 0)
        return -1
    return startIndex
}
