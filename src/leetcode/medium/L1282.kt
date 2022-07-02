package leetcode.medium

fun main() {

}

fun groupThePeople2(groupSizes: IntArray): List<List<Int>> =
    groupSizes.withIndex()
        .groupBy { it.value }
        .map { entry ->
            entry.value.chunked(entry.key){
                it.map {indexed-> indexed.index }
            }
        }.flatten()

fun groupThePeople(groupSizes: IntArray): List<List<Int>> =
    groupSizes.withIndex()
        .groupBy { it.value }
        .map { entry ->
            (0 until entry.value.size / entry.key)
                .map {
                    (it until (entry.key + it))
                        .map { index -> entry.value[index].index }
                }
        }.flatten()

fun groupThePeople3(groupSizes: IntArray): List<List<Int>> {
    return groupSizes.withIndex().groupBy { it.value }.map { entry ->
        val listSize = entry.key
        val list = mutableListOf<List<Int>>()
        var index = 0
        repeat(entry.value.size / listSize) {
            val subList = mutableListOf<Int>()
            repeat(listSize) {
                subList.add(entry.value[index++].index)
            }
            list.add(subList)
        }
        list
    }.flatten()
}

fun groupThePeople4(groupSizes: IntArray): List<List<Int>> {
    val answer = mutableListOf<List<Int>>()
    val map = HashMap<Int, MutableList<Int>>()
    var index = 0
    for (i in groupSizes) {
        (map[i] ?: mutableListOf<Int>().also { map[i] = it }).add(index++)
        if (map[i]!!.size==i){
            answer.add(map[i]!!)
            map[i] = mutableListOf()
        }
    }
    return answer
}
