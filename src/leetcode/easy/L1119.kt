package leetcode.easy

fun main() {
    println(removeVowels("leetcodeisacommunityforcoders").also { println(it) } == "ltcdscmmntyfrcdrs")
    println(removeVowels("aeiou").also { println(it) } == "")
}

private fun removeVowels(s: String): String {
    val stringBuilder = StringBuilder()
    s.forEach {
        if (it != 'a' && it != 'e' && it != 'i' && it != 'o' && it != 'u')
            stringBuilder.append(it)
    }
    return stringBuilder.toString()
}

private fun removeVowels2(s: String) =
    s
        .toList()
        .filter { it != 'a' && it != 'e' && it != 'i' && it != 'o' && it != 'u' }
        .joinToString("")
