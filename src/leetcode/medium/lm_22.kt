package leetcode.medium

fun main() {
    generateParenthesis(4)
}

private fun generateParenthesis(n: Int): List<String> {
    if (n == 0)
        return listOf("")
    val list = mutableListOf<String>()
    for (i in 0 until n) {
        for (l in generateParenthesis(i)) {
            for (r in generateParenthesis(n - i - 1))
                StringBuilder("(").apply {
                    append(l)
                    append(")")
                    append(r)
                }.also { list.add(it.toString()) }
        }
    }
    return list
}
