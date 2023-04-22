package leetcode.easy

fun main() {
    println(validMountainArray(intArrayOf(2, 1)))//f
    println(validMountainArray(intArrayOf(1)))//f
    println(validMountainArray(intArrayOf(3, 5, 5)))//f
    println(validMountainArray(intArrayOf(0, 3, 2, 1)))//t
    println(validMountainArray(intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)))//f
    println(validMountainArray(intArrayOf(9, 8, 7)))//f
}

private fun validMountainArray(arr: IntArray): Boolean {
    var idx = 0
    while (idx + 1 < arr.size && arr[idx] < arr[idx + 1]) idx++
    if (idx == 0 || idx == arr.lastIndex)
        return false
    while (idx + 1 < arr.size && arr[idx] > arr[idx + 1]) idx++
    return idx == arr.lastIndex
}

private fun validMountainArray2(arr: IntArray): Boolean {
    if (arr.size < 3)
        return false
    if (arr[0] >= arr[1])
        return false
    var goingUp = true
    var lastValue = arr[0]
    for (i in 1..arr.lastIndex) {
        val currentValue = arr[i]
        if (lastValue == currentValue)
            return false
        if (lastValue < currentValue) {
            if (!goingUp)
                return false
            lastValue = arr[i]
        }
        if (lastValue > currentValue)
            if (goingUp)
                goingUp = false
        lastValue = arr[i]
    }
    return !goingUp
}
