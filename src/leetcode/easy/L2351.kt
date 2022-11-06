package leetcode.easy

fun main() {

}

private fun repeatedCharacter(s: String): Char {
    val set = HashSet<Char>()
    for (c in s) {
        if (!set.add(c))
            return c
    }
    return s.last()
}
