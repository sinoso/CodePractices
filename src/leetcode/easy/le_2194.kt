package leetcode.easy

fun main() {
    println(cellsInRange("K1:L2").joinToString(", "))
}

private fun cellsInRange(s: String): List<String> = (s[0]..s[3]).flatMap { prefix -> (s[1]..s[4]).map { "$prefix$it" } }

private fun cellsInRange2(s: String): List<String> {
    val answer = mutableListOf<String>()
    for (i in s[0]..s[3])
        for (j in s[1]..s[4])
            answer.add("$i$j")
    return answer
}
