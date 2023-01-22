package leetcode.easy

fun main() {

}

private fun findRestaurant(list1: Array<String>, list2: Array<String>): Array<String> {
    val map = list1.withIndex().associate { it.value to it.index }
    var min = Int.MAX_VALUE

    val answerList: MutableList<String> = mutableListOf()
    for (i in list2.indices) {
        val list1Index = map[list2[i]] ?: continue
        val indexSum = i + list1Index
        if (indexSum > min)
            continue
        if (indexSum < min) {
            min = indexSum
            answerList.clear()
        }
        answerList.add(list2[i])
    }
    return answerList.toTypedArray()
}

