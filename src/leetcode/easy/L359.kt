package leetcode.easy

fun main() {

}

class Logger() {
    private val map = HashMap<String, Int>()
    fun shouldPrintMessage(timestamp: Int, message: String): Boolean {
        val last = map[message] ?: -10
        if (last > timestamp)
            return false
        map[message] = timestamp + 10
        return true
    }

}
