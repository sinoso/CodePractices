package leetcode.medium


fun main() {
    smallestEquivalentString(s1 = "leetcode", s2 = "programs", baseStr = "sourcecode")
}

private fun smallestEquivalentString(s1: String, s2: String, baseStr: String): String {
    val table = IntArray('z' - 'a' + 1) { it }

    for (i in s1.indices) {
        merge(s1[i] - 'a', s2[i] - 'a', table)
    }

    val sb = StringBuilder()
    for (c in baseStr) {
        sb.append('a' + getRoot(c - 'a', table))
    }

    return sb.toString()
}

private fun getRoot(index: Int, table: IntArray): Int {
    val rootIndex = table[index]

    if (index == rootIndex) {
        return index
    }
    return getRoot(rootIndex, table)
}

private fun merge(c1: Int, c2: Int, table: IntArray) {
    val c1Root = getRoot(c1, table)
    val c2Root = getRoot(c2, table)
    if (c1Root == c2Root)
        return
    if (c1Root > c2Root) {
        table[c1Root] = c2Root
    } else {
        table[c2Root] = c1Root
    }
}
