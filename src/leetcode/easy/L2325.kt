package leetcode.easy

fun main() {

}

private fun decodeMessage(key: String, message: String): String =
    with(HashMap<Char, Char>()) {
        this[' '] = ' '
        key.fold('a') { acc, c ->
            if (this[c] == null) {
                this[c] = acc
                acc + 1
            } else
                acc
        }
        message.fold(StringBuilder()) { acc, c -> acc.append(this[c]) }.toString()
    }

private fun decodeMessage2(key: String, message: String): String {
    val map = HashMap<Char, Char>()
    var value = 'a'
    key.replace(" ", "").forEach {
        map[it] ?: run { map[it] = value++ }
    }
    val sb = StringBuilder()
    for (c in message) {
        sb.append(if (c != ' ') map[c] else ' ')
    }
    return sb.toString()
}
