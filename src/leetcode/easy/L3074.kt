package leetcode.easy

fun main() {

}

private fun minimumBoxes(apple: IntArray, capacity: IntArray): Int {
    var sum = apple.sum()
    capacity.sortDescending()
    var index = 0
    while (sum > 0) {
        sum -= capacity[index++]
    }
    return index
}