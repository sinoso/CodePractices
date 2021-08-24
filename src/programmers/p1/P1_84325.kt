package programmers.p1

fun main() {
    println(solution(arrayOf("SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"), arrayOf("PYTHON", "C++", "SQL"), intArrayOf(7, 5, 5)))
}

private fun solution(table: Array<String>, languages: Array<String>, preference: IntArray): String =
        table
                .map { string ->
                    Pair(string.split(" "), intArrayOf(0))
                }
                .map { pair ->
                    pair.also {
                        languages.mapIndexed { index, language ->
                            if (pair.first.contains(language))
                                pair.second[0] += (6 - pair.first.indexOf(language)) * preference[index]
                        }
                    }
                }
                .sortedBy { value -> value.first[0] }
                .sortedByDescending { value2 -> value2.second[0] }.first().first[0]

private fun solution2(table: Array<String>, languages: Array<String>, preference: IntArray): String {
    var table = arrayOf(
            intArrayOf(0, 4, 5, 0, 1, 0, 2, 3, 0),
            intArrayOf(0, 1, 3, 2, 5, 4, 0, 0, 0),
            intArrayOf(0, 2, 1, 5, 4, 0, 0, 3, 0),
            intArrayOf(2, 5, 4, 0, 0, 0, 0, 3, 1),
            intArrayOf(0, 5, 4, 0, 1, 0, 3, 2, 0))

    var result = Array(5) { 0 }
    for (i in languages.indices) {
        var idx = when (languages[i]) {
            "KOTLIN" -> 0
            "JAVA" -> 1
            "JAVASCRIPT" -> 2
            "C" -> 3
            "C++" -> 4
            "C#" -> 5
            "SQL" -> 6
            "PYTHON" -> 7
            "PHP" -> 8
            else -> -1
        }
        for (j in result.indices) {
            result[j] += table[j][idx] * preference[i]
        }
    }
    var max = -1
    var maxIdx = -1
    for (i in result.indices) {
        if (result[i] > max) {
            max = result[i]
            maxIdx = i
        }
    }

    return when (maxIdx) {
        0 -> "CONTENTS"
        1 -> "GAME"
        2 -> "HARDWARE"
        3 -> "PORTAL"
        4 -> "SI"
        else -> "몰?루"
    }
}