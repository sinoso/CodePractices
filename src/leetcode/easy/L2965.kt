package leetcode.easy

fun main() {
    findMissingAndRepeatedValues(arrayOf(intArrayOf(1, 3), intArrayOf(2, 2)))
}

private fun findMissingAndRepeatedValues(grid: Array<IntArray>): IntArray {
    val answer = intArrayOf(0, 0)
    val countOfNumbers = grid.size * grid.size
    var sum = ((countOfNumbers + 1.0) / 2) * countOfNumbers
    val hashSet = HashSet<Int>()
    for (array in grid) {
        for (i in array) {
            if (hashSet.add(i)) {
                sum -= i
            } else {
                answer[0] = i
            }
        }
    }
    answer[1] = sum.toInt()
    return answer
}