package leetcode.easy

fun main() {
}

private fun countMatches(items: List<List<String>>, ruleKey: String, ruleValue: String): Int {
    val key = when (ruleKey) {
        "type" -> 0
        "color" -> 1
        "name" -> 2
        else -> 0
    }
    return items.filter { it[key] == ruleValue }.size
}
