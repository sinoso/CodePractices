package programmers

fun main() {
    println(
        solution(
            arrayOf("muzi", "frodo", "apeach", "neo"),
            arrayOf("muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"),
            2
        ).joinToString()
    )
    println(
        solution(
            arrayOf("con", "ryan"),
            arrayOf("ryan con", "ryan con", "ryan con", "ryan con"),
            2
        ).joinToString()
    )
}

private fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray =
    report.map { it.split(" ") }
        .groupBy { it[1] }
        .asSequence()
        .map { it.value.distinct() }
        .filter { it.size >= k }
        .flatten()
        .map { it[0] }
        .groupingBy { it }
        .eachCount()
        .run { id_list.map { getOrDefault(it, 0) }.toIntArray() }

