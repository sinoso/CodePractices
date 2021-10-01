package leetcode.easy

fun main() {
    println(finalValueAfterOperations(arrayOf("--X", "X++", "X++")))

}


private fun finalValueAfterOperations(operations: Array<String>) = operations.map { if(it[1]=='-') -1  else 1 }.sum()
private fun finalValueAfterOperations2(operations: Array<String>): Int =
        operations.groupBy { it }.map { if (it.key.contains("--")) it.value.size * -1 else it.value.size }.sum()