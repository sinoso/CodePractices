package Programmers

fun main() {
    println(solution("a B z", 4))
}

private fun solution(s: String, n: Int): String {
//    'a' = 97 'z'= 122 'A' = 65 'Z' = 90
    var charArray = s.toCharArray()
    for (i in charArray.indices) {
        var ch = charArray[i].toInt()
        when (ch) {
            in 97..122 -> {
                ch += n
                if (ch>122)
                    ch-=26
            }
            in 65..90 -> {
                ch += n
                if (ch>90)
                    ch-=26
            }
        }
        charArray[i] = ch.toChar()
    }
    return String(charArray)
}