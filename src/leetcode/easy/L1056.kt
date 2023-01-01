package leetcode.easy

fun main() {

}

private fun confusingNumber(n: Int): Boolean {
    val nToString = n.toString().reversed()
    val sb = StringBuilder()
    val invalidSet = setOf('2', '3', '4', '5', '7')
    for (c in nToString) {
        if (c in invalidSet)
            return false
        when (c) {
            '0' -> sb.append('0')
            '1' -> sb.append('1')
            '6' -> sb.append('9')
            '8' -> sb.append('8')
            '9' -> sb.append('6')
        }
    }
    return n != sb.toString().toInt()
}
