package leetcode.medium


fun main() {
    findDuplicate(
        arrayOf(
            "root/a 1.txt(abcd) 2.txt(efgh)",
            "root/c 3.txt(abcd)",
            "root/c/d 4.txt(efgh)",
            "root 4.txt(efgh)"
        )
    )
}

// 20:45 ~ 21:04
private fun findDuplicate(paths: Array<String>): List<List<String>> {
    return paths
        .map { it.split(" ").run(::pathToContent) }
        .fold(HashMap<String, MutableList<String>>()) { acc, list ->
            list.forEach { acc[it.second] = (acc[it.second] ?: mutableListOf()).apply { add(it.first) } }
            acc
        }.values.filter { it.size > 1 }
}

fun pathToContent(list: List<String>): List<Pair<String, String>> {
    return (1..list.lastIndex).map {
        list[it].split('(').run {
            "${list[0]}/${this[0]}" to this[1]
        }
    }
}
