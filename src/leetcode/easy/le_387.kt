package leetcode.easy

fun main() {
    println(firstUniqChar("leetcode"))//0
    println(firstUniqChar("loveleetcode"))//2
    println(firstUniqChar("aabb"))//-1
}

private fun firstUniqChar(s: String): Int {
    val set = HashSet<Char>()
    val map = LinkedHashMap<Char, Int>()
    s.forEachIndexed { index, c ->
        if (set.add(c))
            map[c] = index
        else
            map[c] = -1
    }
    return map.values.firstOrNull { it != -1 } ?: -1
}
