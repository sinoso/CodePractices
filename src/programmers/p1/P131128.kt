package programmers.p1

fun main() {
}

fun solution(X: String, Y: String): String {
    val xCountMap = X.groupingBy { it }.eachCount()
    val yCountMap = Y.groupingBy { it }.eachCount()
    val duplicateKeys = yCountMap.keys.filter { xCountMap.contains(it) }
    if (duplicateKeys.contains('0') && duplicateKeys.size == 1)
        return "0"
    val sb = StringBuilder()
    duplicateKeys.sortedByDescending { it }.forEach {key->
        repeat(xCountMap[key]!!.coerceAtMost(yCountMap[key]!!)){
            sb.append(key)
        }
    }
    return if (sb.isEmpty())
        "-1"
    else
        sb.toString()
}
