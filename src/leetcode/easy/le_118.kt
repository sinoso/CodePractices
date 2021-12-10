package leetcode.easy


fun main() {
    println(generate(1).joinToString())
    println(generate(2).joinToString())
    println(generate(3).joinToString())
    println(generate(4).joinToString())
    println(generate(5).joinToString())
    println(generate(10).joinToString())

}

private fun generate(numRows: Int): List<List<Int>> {
    val answer = mutableListOf<List<Int>>()
    val acc = mutableListOf<Int>()
    for (i in 0 until numRows) {
        acc.add(0, 1)
        for (j in 1 until acc.size - 1)
            acc[j] = acc[j] + acc[j + 1]
        answer.add(ArrayList(acc))
    }
    return answer
}

private fun generate2(numRows: Int): List<List<Int>> {
    val answer = mutableListOf<List<Int>>()
    answer.add(listOf(1))
    if (numRows == 1)
        return answer
    answer.add(listOf(1, 1))
    if (numRows == 2)
        return answer
    for (i in 3..numRows)
        MutableList(i - 2) { index -> answer[i - 2][index] + answer[i - 2][index + 1] }.apply {
            add(0, 1)
            add(1)
            answer.add(this)
        }
    return answer
}
