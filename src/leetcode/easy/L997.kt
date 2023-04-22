package leetcode.easy

fun main() {
    println(findJudge(2, arrayOf(intArrayOf(1, 2))).also { print("${it == 2} ") })
    println(findJudge(2, arrayOf()).also { print("${it == -1} ") })
    println(findJudge(3, arrayOf(intArrayOf(1, 3), intArrayOf(2, 3))).also { print("${it == 3} ") })
    println(findJudge(3, arrayOf(intArrayOf(1, 3), intArrayOf(2, 3), intArrayOf(3, 1))).also { print("${it == -1} ") })
    println(findJudge(1, arrayOf()).also { print("${it == 1} ") })
}

private fun findJudge(n: Int, trust: Array<IntArray>): Int {
    val trustSomeoneMap = HashMap<Int, Boolean>().apply { repeat(n) { this[it + 1] = false } }
    val numberOfTrustedMap = HashMap<Int, Int>().apply { repeat(n) { this[it + 1] = 0 } }
    trust.forEach {
        trustSomeoneMap[it[0]] = true
        numberOfTrustedMap[it[1]] = numberOfTrustedMap[it[1]]!! + 1
    }
    val judgeAbles = trustSomeoneMap.filter { !it.value }.map { it.key }
    if (judgeAbles.isEmpty())
        return -1
    val judge = judgeAbles.filter { numberOfTrustedMap[it] == n - 1 }
    if (judge.size != 1)
        return -1
    return judge.first()
}

private fun findJudge2(n: Int, trust: Array<IntArray>): Int {
    if (n == 1 && trust.isEmpty())
        return 1
    val grouped = trust.groupBy { it[1] }
//    val maxTrust = grouped.maxOfOrNull { it.value.size } ?: 0
    //leetcode don't use version 1.4.+
    val maxTrust = grouped.run {
        val iterator = iterator()
        if (!iterator.hasNext())
            return@run null
        var max = Int.MIN_VALUE
        while (iterator.hasNext())
            max = max.coerceAtLeast(iterator.next().value.size)
        max
    } ?: 0

    if (maxTrust != n - 1)
        return -1
    val a = grouped.filter { it.value.size == maxTrust }.filter { trust.none { origin -> origin[0] == it.key } }
    if (a.size != 1)
        return -1
    return a.keys.first()
}

