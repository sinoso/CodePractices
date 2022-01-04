package leetcode.easy


fun main() {
    println(isAnagram("anagram", "nagaram"))
    println(isAnagram("rat", "car"))
    println(isAnagram("a", "ab"))
}


private fun isAnagram(s: String, t: String): Boolean {
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
