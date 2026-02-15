package leetcode.easy

fun main() {

}

private fun canBeTypedWords(text: String, brokenLetters: String): Int {
    val set = brokenLetters.toSet()
   return text.split(" ").count { it.all { c -> !set.contains(c) } }
}