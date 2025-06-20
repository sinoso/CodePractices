package leetcode.easy

fun main() {

}

private fun maximumNumberOfStringPairs(words: Array<String>): Int {
    var count = 0
    val set = HashSet<String>()
    for (s in words) {
        if (set.contains(s)) {
            count++
            continue
        }
        set.add(s.reversed())
    }
    return count
}