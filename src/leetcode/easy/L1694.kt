package leetcode.easy

import java.util.LinkedList
import java.util.Queue

fun main() {

}

private fun reformatNumber(number: String): String {
    val queue: Queue<Char> = LinkedList()
    for (c in number) {
        if (c.isDigit())
            queue.add(c)
    }
    val chunks = queue.chunked(3)
    if (queue.size > 3 && queue.size % 3 == 1) {
        val sb = StringBuilder()
        for (i in 0..(chunks.lastIndex - 2)) {
            chunks[i].forEach(sb::append)
            sb.append('-')
        }
        sb.append(chunks[chunks.lastIndex - 1][0])
        sb.append(chunks[chunks.lastIndex - 1][1])
        sb.append('-')
        sb.append(chunks[chunks.lastIndex - 1][2])
        sb.append(chunks[chunks.lastIndex][0])
        return sb.toString()
    }
    return chunks.joinToString("-") { it.joinToString("") }
}
