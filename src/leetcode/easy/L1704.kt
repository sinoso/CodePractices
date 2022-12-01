package leetcode.easy

fun main() {

}

private fun halvesAreAlike(s: String): Boolean {
    val halfIndex = s.lastIndex / 2
    val set = hashSetOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
    var count = 0
    for (i in 0..halfIndex) {
        if (set.contains(s[i]))
            count++
    }
    for (i in (halfIndex + 1)..s.lastIndex) {
        if (set.contains(s[i]))
            count--
    }
    return count == 0
}
