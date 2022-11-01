package leetcode.medium


fun main() {

}

private fun smallestCommonElement(mat: Array<IntArray>): Int {
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
