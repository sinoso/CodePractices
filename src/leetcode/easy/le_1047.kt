package leetcode.easy

fun main() {
    println(removeDuplicates("abbaca") == "ca")
    println(removeDuplicates("azxxzy") == "ay")
}

private fun removeDuplicates(s: String): String {
    val sb = StringBuilder()
    s.forEach {
        if (sb.isEmpty() || sb.last() != it) {
            sb.append(it)
            return@forEach
        }
        if(sb.last()==it)
            sb.deleteCharAt(sb.lastIndex)
    }
    return sb.toString()
}
