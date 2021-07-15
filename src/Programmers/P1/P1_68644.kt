package Programmers

fun main() {
    println(solution(intArrayOf(2, 1, 3, 4, 1)).contentToString())
    println(solution(intArrayOf(2, 1)).contentToString())
    println(solution(intArrayOf(9, 19,1,3,4,5,6,0,0)).contentToString())
}

private fun solution(numbers: IntArray): IntArray {
    var set = HashSet<Int>()
    for (i in numbers.indices)
        for (j in (i + 1)..numbers.lastIndex) {
            set.add(numbers[i] + numbers[j])
        }
    return set.toIntArray().sortedArray()
}