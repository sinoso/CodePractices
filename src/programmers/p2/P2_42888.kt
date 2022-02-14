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


private fun solution2(record: Array<String>): Array<String> {
    val users = HashMap<String, String>()
    val array = Array(record.filter { !it.contains("Change") }.size) { "" }
    var arrayIdx = 0
    record.forEach {
        with(it.split(" ")) {
            when (size) {
                2 -> array[arrayIdx++] = "${this[0]},${this[1]}"
                3 -> {
                    if (this[0] != "Change")
                        array[arrayIdx++] = "${this[0]},${this[1]}"
                    users[this[1]] = this[2]
                }
            }
        }
    }
    return array.apply {
        indices.forEach {
            this[it] = this[it].split(",").run {
                when (this[0]) {
                    "Enter" -> "${users[this[1]]}님이 들어왔습니다."
                    "Leave" -> "${users[this[1]]}님이 나갔습니다."
                    else -> ""
                }
            }
        }
    }
}


private fun solution(record: Array<String>): Array<String> {
    val users = HashMap<String, String>()
    val recorded = ArrayList<Pair<String, String>>()
    record.forEach {
        with(it.split(" ")) {
            when (size) {
                2 -> recorded.add(Pair(this[0], this[1]))

                3 -> if (this[0] != "Change") {
                    recorded.add(Pair(this[0], this[1]))
                    users[this[1]] = this[2]
                }
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
