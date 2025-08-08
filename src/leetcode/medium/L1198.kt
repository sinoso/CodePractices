package leetcode.medium


fun main() {

}

private fun smallestCommonElement(mat: Array<IntArray>): Int {
    var left = mat.first().first()
    var right = mat.first().last()
    val map: HashMap<Int, Int> = mat.first().associateWithTo(HashMap()) { 1 }
    for (index in 1..mat.lastIndex) {
        val currentArray = mat[index]
        if (currentArray.first() > left) {
            left = currentArray.first()
        }
        if (currentArray.last() < right) {
            right = currentArray.last()
        }
        if (left > right)
            return -1
        for (key in mat[index]) {
            if (key in left..right) {
                val value = map[key] ?: continue
                map[key] = value + 1
            }
        }
    }
    val maxCount = mat.size
    var minKey = Int.MAX_VALUE
    for ((key, value) in map) {
        if (value == maxCount) {
            minKey = minKey.coerceAtMost(key)
        }
    }
    return if (minKey == Int.MAX_VALUE) -1 else minKey
}

private fun smallestCommonElement2(mat: Array<IntArray>): Int {
    var set: MutableSet<Int> = mat.first().toMutableSet()
    var tempSet = mutableSetOf<Int>()
    for (index in 1..mat.lastIndex) {
        mat[index].forEach {
            if (set.contains(it))
                tempSet.add(it)
        }
        set = tempSet
        tempSet = mutableSetOf()
        if (set.isEmpty())
            break
    }
    if (set.isEmpty())
        return -1
    return set.reduce { acc, i -> acc.coerceAtMost(i) }
}
