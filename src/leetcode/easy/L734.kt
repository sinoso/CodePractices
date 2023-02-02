package leetcode.easy

fun main() {

}

private fun areSentencesSimilar(
    sentence1: Array<String>,
    sentence2: Array<String>,
    similarPairs: List<List<String>>
): Boolean {
    if (sentence1.size != sentence2.size)
        return false

    val map = hashMapOf<String, MutableSet<String>>()
    similarPairs.forEach { (s1, s2) ->
        map[s1] = (map[s1] ?: mutableSetOf()).apply { add(s2) }
        map[s2] = (map[s2] ?: mutableSetOf()).apply { add(s1) }
    }
    for (i in sentence1.indices) {
        val s1 = sentence1[i]
        val s2 = sentence2[i]
        if (s1 == s2)
            continue
        val s1Set = map[s1]
        val s2Set = map[s2]
        if (s1Set?.contains(s2) == true)
            continue
        if (s2Set?.contains(s1) == true)
            continue
        return false
    }
    return true
}
