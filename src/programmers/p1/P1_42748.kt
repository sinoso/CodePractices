package programmers

fun main() {
    println(solution(intArrayOf(1, 5, 2, 6, 3, 7, 4), arrayOf(intArrayOf(2, 5, 3), intArrayOf(4, 4, 1), intArrayOf(1, 7, 3))).contentToString())
}

private fun solution(array: IntArray, commands: Array<IntArray>): IntArray = commands.map { command -> array.clone().copyOfRange(command[0] - 1, command[1]).sorted()[command[2] - 1] }.toIntArray()