package leetcode.medium

fun main() {

}

private fun subsets(nums: IntArray): List<List<Int>> {
    var answer: MutableList<MutableList<Int>> = mutableListOf(mutableListOf())
    for (i in nums) {
        answer = rec(i, answer)
    }
    return answer
}

fun rec(value: Int, list: MutableList<MutableList<Int>>): MutableList<MutableList<Int>> {
    val newList = mutableListOf<MutableList<Int>>()
    for (i in list.indices) {
        newList.add(list[i].toMutableList().apply { add(value) })
    }
    list.addAll(newList)
    return list
}
