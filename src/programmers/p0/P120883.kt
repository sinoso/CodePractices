package programmers.p0

fun main() {
    solution(
        arrayOf("meosseugi", "1234"),
        arrayOf(
            arrayOf("rardss", "123"),
            arrayOf("yyoom", "1234"),
            arrayOf("meosseugi", "1234")
        )
    )
}

private fun solution(id_pw: Array<String>, db: Array<Array<String>>): String {
    val user = db.find { it[0] == id_pw[0] } ?: return "fail"
    if (user[1] == id_pw[1])
        return "login"
    return "wrong pw"
}
