package leetcode.easy

fun main() {
    println(areOccurrencesEqual("abacbc"))//t
    println(areOccurrencesEqual("aaabb"))//f
}

private fun areOccurrencesEqual(s: String): Boolean {
    val map = HashMap<Char, Int>()
    s.forEach { map[it] = map.getOrDefault(it, 0) + 1 }
    map.values.also {
        it.fold(it.first()) { a: Int, b: Int ->
            if (a != b)
                return false
            a
        }
    }
    return true
}

private fun areOccurrencesEqual2(s: String): Boolean =
    s.groupingBy { it }.eachCount().map { it.value }.toSet().size == 1

