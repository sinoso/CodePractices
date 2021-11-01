package leetcode.easy

fun main() {
    println(addStrings("123", "11"))
    println(addStrings("1", "9"))
//    println('0'.toInt())
}

private fun addStrings(num1: String, num2: String): String {
    val num1Iterator = num1.reversed().chars().iterator()
    val num2Iterator = num2.reversed().chars().iterator()
    val sb = StringBuilder()
    var acc = false
    while (num1Iterator.hasNext() && num2Iterator.hasNext()) {
        val sum = num1Iterator.next() + num2Iterator.next() - 48 + if (acc) 1 else 0
        acc = sum > 57
        sb.append((if (acc) sum - 10 else sum).toChar())
    }
    with(if (num1Iterator.hasNext()) num1Iterator else num2Iterator) {
        while (hasNext()) {
            val sum = next() + if (acc) 1 else 0
            acc = sum > 57
            sb.append((if (acc) sum - 10 else sum).toChar())
        }
    }
    if (acc)
        sb.append(1)
    return sb.reversed().toString()
}
