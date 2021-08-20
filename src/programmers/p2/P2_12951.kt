package programmers.p2

fun main() {
    println(solution("3people unFollowed me"))
    println(solution("for the last week"))
    println(solution("for 3the 3LastWeek week "))
    println(solution("fae"))
}

private fun solution(s: String): String {
    var list = s.split(" ").toMutableList()
    for (i in list.indices) {
        list[i] = list[i].toLowerCase()
        if (list[i].isNotEmpty() && (list[i][0] in 'a'..'z' || list[i][0] in 'A'..'Z')) {
            list[i] = list[i][0].toUpperCase() + list[i].substring(1)
        }
    }
    return list.joinToString(" ", "", "")
}