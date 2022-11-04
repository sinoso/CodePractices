package leetcode.easy

fun main() {

}


private fun reverseVowels(s: String): String {
    val array = s.toCharArray()
    val set = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
    val indexList = array.withIndex().filter { set.contains(it.value) }.map { it.index }
    var f = 0
    var r = indexList.lastIndex
    while (f < r) {
        val temp = array[indexList[f]]
        array[indexList[f]] = array[indexList[r]]
        array[indexList[r]] = temp
        f++
        r--
    }
    return array.joinToString("")
}
