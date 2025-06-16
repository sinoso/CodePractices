package leetcode.easy

fun main() {
    duplicateZeros(intArrayOf(1, 0, 2, 3, 0, 4, 5, 0))
    duplicateZeros(intArrayOf(0, 1, 0))
}

private fun duplicateZeros(arr: IntArray): Unit {
    var frontIndex = -1
    var count = 0
    while (count < arr.size) {
        frontIndex++
        if (arr[frontIndex] == 0) {
            count++
        }
        count++
    }
    var rearIndex = arr.lastIndex
    if (count > arr.size) {
        arr[rearIndex] = 0
        rearIndex--
        frontIndex--
    }
    while (rearIndex >= 0) {
        if (arr[frontIndex] == 0) {
            arr[rearIndex--] = arr[frontIndex]
        }
        arr[rearIndex--] = arr[frontIndex--]
    }
}
//0102
//0010'0

