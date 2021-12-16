package leetcode.easy


fun main() {
    println(
        highFive(
            arrayOf(
                intArrayOf(2, 93),
                intArrayOf(1, 91),
                intArrayOf(1, 92),
                intArrayOf(2, 97),
                intArrayOf(1, 60),
                intArrayOf(2, 77),
                intArrayOf(1, 65),
                intArrayOf(1, 87),
                intArrayOf(1, 100),
                intArrayOf(2, 100),
                intArrayOf(2, 76)
            )
        )
    )
}


private fun highFive(items: Array<IntArray>): Array<IntArray> {
    val array = items.sortedByDescending { it[1] }
    val set = mutableSetOf<Int>()
    val map = mutableMapOf<Int, Int>()
    val countMap = mutableMapOf<Int, Int>()
    array.forEach {
        if (set.contains(it[0]))
            return@forEach
        val count = countMap.getOrDefault(it[0], 0) + 1
        countMap[it[0]] = count
        map[it[0]] = map.getOrDefault(it[0], 0) + it[1]
        if (count == 5)
            set.add(it[0])
    }
    return map.map { intArrayOf(it.key,it.value/5) }.sortedBy { it[0] }.toTypedArray()
}

private fun highFive2(items: Array<IntArray>): Array<IntArray> =
    items
        .groupBy { it.first() }
        .map { entry ->
            intArrayOf(
                entry.key, entry.value
                    .sortedByDescending { it[1] }
                    .take(5)
                    .map { it[1] }
                    .average()
                    .toInt()
            )
        }.sortedBy { it[0] }
        .toTypedArray()

private fun highFive3(items: Array<IntArray>): Array<IntArray> {
    val list = items.groupBy { it.first() }.toList().sortedBy { it.first }
    val answer = Array(list.size) {
        var sum = 0
        val elements = list[it].second.sortedByDescending { pair -> pair[1] }
        repeat(5) { index -> sum += elements[index][1] }
        intArrayOf(list[it].first, sum / 5)
    }
    return answer
}


private fun highFive4(items: Array<IntArray>): Array<IntArray> {
    val array = items.sortedWith(compareBy<IntArray> { it[0] }.thenByDescending { it[1] })
    var currentKey = array[0][0]
    var currentCount = 0
    var sum = 0
    val answerList = mutableListOf<IntArray>()
    for (subArray in array) {
        if (currentCount == 5 && currentKey == subArray[0])
            continue
        else if (currentKey != subArray[0]) {
            currentKey = subArray[0]
            currentCount = 0
            sum = 0
        }
        currentCount++
        sum += subArray[1]
        if (currentCount == 5)
            answerList.add(intArrayOf(subArray[0], sum / 5))
    }
    return answerList.toTypedArray()
}
