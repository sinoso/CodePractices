package programmers.p2


fun main() {
    println(
        solution(
            arrayOf(
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"
            )
        ).joinToString()
    )
}


private fun solution(record: Array<String>): Array<String> {
    val users = HashMap<String, String>()
    val recorded = ArrayList<Pair<String, String>>()
    record.forEach {
        with(it.split(" ")) {
            when (size) {
                2 -> recorded.add(Pair(this[0], this[1]))

                3 -> if (this[0] != "Change")
                    recorded.add(Pair(this[0], this[1]))
                else users[this[1]] = this[2]
            }
        }
    }
    return recorded.map {
        when (it.first) {
            "Enter" -> "${users[it.second]}님이 들어왔습니다."
            "Leave" -> "${users[it.second]}님이 나갔습니다."
            else -> ""
        }
    }.toTypedArray()
}
