package leetcode.easy

fun main() {

}

private fun findSpecialInteger(arr: IntArray): Int {
    var lastValue = 0
    var count = 0
    val threshold = arr.size / 4
    for (i in arr) {
        if (i == lastValue)
            count++
        else {
            count = 1
            lastValue = i
        }
        if (count > threshold)
            return i
    }
    return 0
}