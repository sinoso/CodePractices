package leetcode.easy

fun main() {

}

private fun countConsistentStrings(allowed: String, words: Array<String>): Int {
    val allowedSet = HashSet<Char>()
    for (c in allowed) {
        allowedSet.add(c)
    }
    var answer = 0
    loop@ for (word in words) {
        for (c in word) {
            if (!allowedSet.contains(c))
                continue@loop
        }
        answer++
    }
    return answer
}

private fun countConsistentStrings2(allowed: String, words: Array<String>): Int =
    (allowed.toSet()).let { allowedSet -> words.count { allowedSet.containsAll(it.toSet()) } }

