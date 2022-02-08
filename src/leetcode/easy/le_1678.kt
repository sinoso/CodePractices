package leetcode.easy

fun main() {

    println(interpret("G()(al)"))
    println(interpret("G()()()()(al)"))
    println(interpret("(al)G(al)()()G"))
}

private fun interpret(command: String): String =
    command.replace("()", "o")
        .replace("[()]".toRegex(), "")

