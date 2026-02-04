package leetcode.easy

fun main() {

}

private fun trimMean(arr: IntArray): Double {
    arr.sort()
    val percent5 = arr.size / 20
    var sum = 0.0
    for (i in percent5..(arr.lastIndex - percent5)) {
        sum += arr[i]
    }
    return sum / (arr.size - percent5 * 2)
}