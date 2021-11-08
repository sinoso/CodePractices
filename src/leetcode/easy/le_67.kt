package leetcode.easy


fun main() {
    println(addBinary("11", "1"))
    println(addBinary("1010", "1011"))
    println(addBinary("11111111111", "1011"))
}

private fun addBinary(a: String, b: String): String {
    val aIterator = a.reversed().chars().iterator()
    val bIterator = b.reversed().chars().iterator()
    var acc = false
    val sb = StringBuilder()
    while (aIterator.hasNext() && bIterator.hasNext()) {
        val aChar = aIterator.next()
        val bChar = bIterator.next()
        if (aChar == bChar) {
            sb.append(if (acc) '1' else '0')
            acc = aChar == 49
            continue
        }
        sb.append(if (acc) '0' else '1')
    }
    val leftIterator = if (aIterator.hasNext()) aIterator else bIterator
    while (leftIterator.hasNext() && acc) {
        val nextChar = leftIterator.next()
        if (nextChar == 48) {
            sb.append('1')
            acc = false
        } else
            sb.append('0')
    }
    while (leftIterator.hasNext())
        sb.append(leftIterator.next().toChar())
    if (acc)
        sb.append('1')
    return sb.reversed().toString()
}
