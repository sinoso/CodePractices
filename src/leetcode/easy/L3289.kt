package leetcode.easy

fun main() {

}

private fun getSneakyNumbers(nums: IntArray): IntArray {
        val countMap = HashMap<Int, Int>()
        for (i in nums) {
            countMap[i] = (countMap[i] ?: 0) + 1
        }
        return countMap.entries.filter { it.value == 2 }.map { it.key }.toIntArray()
}