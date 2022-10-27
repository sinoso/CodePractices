package leetcode.medium

fun main() {
    countAndSay(1)
    println(countAndSay(4))

}

private fun countAndSay(n: Int, lastString: String = "1"): String {
    if (n == 1)
        return lastString
    val sb = StringBuilder()
    var count = 0
    var last = lastString.first()
    for (i in lastString) {
        if (last == i) {
            count++
            continue
        }
        sb.append(count)
        sb.append(last)
        last = i
        count = 1
    }
    sb.append(count)
    sb.append(last)
    return countAndSay(n - 1, sb.toString())
}
