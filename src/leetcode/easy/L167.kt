package leetcode.easy

fun main() {
    println(twoSum(intArrayOf(2, 7, 11, 15), 9).contentToString())
}


private fun twoSum(numbers: IntArray, target: Int): IntArray {
    var first = 0
    var second = numbers.lastIndex
    while (first != second) {
        when {
            numbers[first] + numbers[second] == target ->
                return intArrayOf(first+1,second+1)
            numbers[first] + numbers[second] > target ->
                second--
            numbers[first] + numbers[second] < target ->
                first++
        }
    }
    return intArrayOf(first+1,second+1)
}

private fun twoSum2(numbers: IntArray, target: Int): IntArray {
    var first = 0
    var second = 0
    for (i in numbers.indices) {
        val target2 = target - numbers[i]
        first = i
        for (j in (i + 1)..numbers.lastIndex) {
            if (second != 0)
                break
            if (numbers[j] == target2)
                second = j
        }
        if (second != 0)
            break
    }
    return intArrayOf(first + 1, second + 1)
}