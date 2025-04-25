package leetcode.easy

fun main() {

}

private fun intersection(nums: Array<IntArray>): List<Int> {
    val table = IntArray(1001)
    val sizeOfNums = nums.size
    for (array in nums) {
        for (i in array) {
            table[i] += 1
        }
    }
    val answer = mutableListOf<Int>()
    for (i in table.indices) {
        if (table[i] == sizeOfNums) {
            answer += i
        }
    }
    return answer
}

private fun intersection2(nums: Array<IntArray>): List<Int> {
    val map = HashMap<Int, Int>()
    val sizeOfNums = nums.size
    for (array in nums) {
        for (i in array) {
            map[i] = (map[i] ?: 0) + 1
        }
    }
    return map.filter { it.value == sizeOfNums }.map { it.key }.sorted()
}