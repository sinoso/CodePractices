package programmers.p2


fun main() {
    println(solution(arrayOf("Enter uid1234 Muzi",
            "Enter uid4567 Prodo",
            "Leave uid1234",
            "Enter uid1234 Prodo",
            "Change uid4567 Ryan")).joinToString())
}


private fun solution(record: Array<String>): Array<String> {
    var users = HashMap<String, String>()
    var recorded = ArrayList<Pair<String, String>>()
    record.forEach { s ->
        var splited = s.split(" ")
        when (splited.size) {
            2 -> {
                recorded.add(Pair(splited[0], splited[1]))
            }
            3 -> {
                if (splited[0] != "Change")
                    recorded.add(Pair(splited[0], splited[1]))
                users[splited[1]] = splited[2]
            }
        }
    }
    return recorded.map { pair ->
        when (pair.first) {
            "Enter" -> "${users[pair.second]}님이 들어왔습니다."
            "Leave" -> "${users[pair.second]}님이 나갔습니다."
            else -> ""
        }
    }.toTypedArray()
}