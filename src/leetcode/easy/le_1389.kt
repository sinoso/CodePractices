package leetcode.easy

fun main() {
    println(createTargetArray(intArrayOf(0, 1, 2, 3, 4), intArrayOf(0, 1, 2, 2, 1)).joinToString())
}


private fun createTargetArray(nums: IntArray, index: IntArray): IntArray {
    val list = arrayListOf<Int>()
    nums.forEachIndexed { idx, i ->
        list.add(index[idx], i)
    }
    return list.toIntArray()
}
