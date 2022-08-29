package programmers.p1

fun main() {
    solution(arrayOf("AN", "CF", "MJ", "RT", "NA"), intArrayOf(5, 3, 2, 7, 5))
}

//14:22 ~ 14:48
private fun solution(survey: Array<String>, choices: IntArray): String =
    choices.zip(survey)
        .filter { it.first != 4 }
        .map { (choice, survey) ->
        val point = choice - 4
        if (survey[0] - survey[1] < 0) {
            survey[1] to (point * -1)
        } else {
            survey[0] to (point)
        }
    }.fold(HashMap<Char, Int>()) { acc, (choice, point) ->
        acc[choice] = acc.getOrDefault(choice, 0) + point
        acc
    }.let { resultMap ->
        with(StringBuilder()) {
            if ((resultMap['T'] ?: 0) >= 0) {
                append('R')
            } else {
                append('T')
            }
            if ((resultMap['F'] ?: 0) >= 0) {
                append('C')
            } else {
                append('F')
            }
            if ((resultMap['M'] ?: 0) >= 0) {
                append('J')
            } else {
                append('M')
            }
            if ((resultMap['N'] ?: 0) >= 0) {
                append('A')
            } else {
                append('N')
            }
            toString()
        }
    }
