package leetcode.easy

fun main() {
    maximumUnits(arrayOf(intArrayOf(1, 3), intArrayOf(2, 2), intArrayOf(3, 1)), 4)
}

private fun maximumUnits(boxTypes: Array<IntArray>, truckSize: Int): Int {
    boxTypes.sortByDescending { (_, unitsPerBox) -> unitsPerBox }
    var left = truckSize
    var answer = 0
    var index = 0
    val max = boxTypes.size
    while (left > 0 && index < max) {
        val (numberOfBox, unitsPerBox) = boxTypes[index++]
        val currentTake = left.coerceAtMost(numberOfBox)
        left -= currentTake
        answer += currentTake * unitsPerBox
    }
    return answer
}