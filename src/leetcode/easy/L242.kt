package leetcode.easy


fun main() {
    println(isAnagram("anagram", "nagaram"))
    println(isAnagram("rat", "car"))
    println(isAnagram("a", "ab"))
}

private fun isAnagram(s: String, t: String): Boolean = mutableMapOf<Char, Int>()
    .apply {
        s.toCharArray().forEach { this[it] = getOrDefault(it, 0) + 1 }
    } == mutableMapOf<Char, Int>()
    .apply {
        t.toCharArray().forEach { this[it] = getOrDefault(it, 0) + 1 }
    }

private fun isAnagram2(s: String, t: String): Boolean {
    val mapS = mutableMapOf<Char, Int>()
        .apply {
            s.forEach { this[it] = getOrDefault(it, 0) + 1 }
        }
    val mapT = mutableMapOf<Char, Int>()
        .apply {
            t.forEach { this[it] = getOrDefault(it, 0) + 1 }
        }
    return mapT == mapS
}

private fun isAnagram3(s: String, t: String): Boolean {
    val a = s.groupingBy { it }.eachCount()
    val b = t.groupingBy { it }.eachCount()
    val largeOne: Map<Char, Int>
    val smallOne: Map<Char, Int>
    if (a.size > b.size) {
        largeOne = a
        smallOne = b
    } else {
        largeOne = b
        smallOne = a
    }
    largeOne.forEach {
        if ((smallOne[it.key] ?: -1) != it.value)
            return false
    }
    return true
}
