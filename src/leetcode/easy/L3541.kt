package leetcode.easy

fun main() {

}

private fun maxFreqSum(s: String): Int {
    val vMap = HashMap<Char, Int>()
    val cMap = HashMap<Char, Int>()
    for (c in s) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            vMap[c] = (vMap[c] ?: 0) + 1
        else
            cMap[c] = (cMap[c] ?: 0) + 1
    }
    return (cMap.maxOfOrNull { it.value } ?: 0) + (vMap.maxOfOrNull { it.value } ?: 0)
}