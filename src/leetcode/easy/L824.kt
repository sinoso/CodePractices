package leetcode.easy


fun main() {
}

fun toGoatLatin(sentence: String): String {
    val sb = StringBuilder()
    val list = sentence.split(' ')
    for (i in list.indices) {
        val currentS = list[i]
        when (currentS[0].lowercaseChar()) {
            'a', 'e', 'i', 'o', 'u' -> {
                sb.append(currentS)
            }

            else -> {
                sb.append(currentS.takeLast(currentS.length - 1))
                sb.append(currentS[0])
            }
        }
        sb.append("ma")
        repeat(i + 1) {
            sb.append('a')
        }
        sb.append(' ')
    }
    return sb.toString().dropLast(1)
}