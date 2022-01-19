package leetcode.easy

fun main() {
    println(wordPattern("abba", "dog cat cat dog")) //true
    println(wordPattern("abba", "dog cat cat fish")) //false
    println(wordPattern(pattern = "aaaa", s = "dog cat cat dog")) //false
    println(wordPattern(pattern = "abba", s = "dog dog dog dog")) //false
    println(wordPattern(pattern = "aaa", s = "aa aa aa aa")) //false
    println(wordPattern(pattern = "aba", s = "dog cat cat")) //false
}

private fun wordPattern(pattern: String, s: String): Boolean =
    with(s.split(" ")) {
        size == pattern.length && toSet().size.let {
            it == pattern.toSet().size && it == pattern.toList().zip(this).toSet().size
        }
    }

private fun wordPattern2(pattern: String, s: String): Boolean =
    s.split(" ").run { this to this.toSet() }.run {
        first.size == pattern.length && second.size == pattern.toSet().size && second.size == pattern.toList()
            .zip(first).toSet().size
    }

private fun wordPattern3(pattern: String, s: String): Boolean =
    (pattern.toList() to s.split(" "))
        .run {
            if (first.size != second.size)
                return false
            val secondSet = second.toSet()
            if (secondSet.size != first.toSet().size || secondSet.size != first.zip(second).toSet().size)
                return false
            true
        }


private fun wordPattern4(pattern: String, s: String): Boolean {
    val map = HashMap<Char, String>()
    val set = HashSet<String>()
    val patternList = pattern.toList()
    val wordList = s.split(" ")
    if (patternList.size != wordList.size)
        return false
    patternList.zip(wordList).forEach {
        if (map[it.first] == null) {
            map[it.first] = it.second
            if (!set.add(it.second))
                return false
        } else if (map[it.first] != it.second)
            return false
    }
    return true
}
