package leetcode.easy

fun main() {
    println(maximumUnits(arrayOf(intArrayOf(1, 3), intArrayOf(2, 2), intArrayOf(3, 1)), 4))
    println(maximumUnits(arrayOf(intArrayOf(5, 10), intArrayOf(2, 5), intArrayOf(4, 7), intArrayOf(3, 9)), 10))

}

private fun maximumUnits(boxTypes: Array<IntArray>, truckSize: Int): Int {
    val sorted = boxTypes.sortedByDescending { it[1] }
    var leftSize = truckSize
    var answer = 0
    for (array in sorted) {
        if (leftSize == 0)
            break
        if (leftSize >= array[0]) {
            answer += array[0] * array[1]
            leftSize -= array[0]
        } else {
            answer += array[1] * leftSize
            break
        }
    }
    return answer
}
