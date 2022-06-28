package leetcode.medium


import printResult
import kotlin.collections.HashSet

fun main() {
    printResult(minDeletions("aab"), 0)
    printResult(minDeletions("aaabbbcc"), 2)
    printResult(minDeletions("ceabaacb"), 2)
    printResult(minDeletions("bbcebab"), 2)
}

private fun minDeletions(s: String): Int =
    with(HashSet<Int>()) {
        s.groupingBy { it }
            .eachCount()
            .map { it.value }
            .filter { !add(it) }
            .sortedBy { it }
            .map {
                var count = 0
                var value = it
                while (!(value == 0 || add(value--)))
                    count++
                count
            }.fold(0) { acc, i -> acc + i }
    }

private fun minDeletions2(s: String): Int {
    var count = 0
    val set = HashSet<Int>()
    val t = s.groupingBy { it }
        .eachCount()
        .map { it.value }
        .filter { !set.add(it) }
        .sortedBy { it }
    for (i in t) {
        var result = set.add(i)
        var low = i - 1
        while (!result) {
            count++
            result = low == 0 || set.add(low--)
        }
    }
    return count
}

private fun minDeletions3(s: String): Int {
    val table = IntArray(26)
    for (c in s) {
        table[c - 'a']++
    }
    var count = 0
    val set = HashSet<Int>()
    val t = table.filter { (it != 0) && (!set.add(it)) }.sortedBy { it }
    for (i in t) {
        var result = set.add(i)
        var low = i - 1
        while (!result) {
            count++
            result = low == 0 || set.add(low--)
        }
    }
    return count
}
