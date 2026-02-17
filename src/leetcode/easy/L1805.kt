package leetcode.easy

import printResult
import java.util.*
import kotlin.collections.HashSet


fun main() {
    printResult(
        expected = 2,
        actual = numDifferentIntegers("035985750011523523129774573439111590559325a1554234973")
    )

}

private fun numDifferentIntegers(word: String): Int {
    val set = HashSet<String>()
    val queue: Queue<Char> = LinkedList()
    for (i in word.indices) {
        if (word[i].isDigit()) {
            queue.add(word[i])
        } else {
            if (queue.isNotEmpty()) {
                while (queue.peek() == '0') {
                    queue.poll()
                }
                set.add(queue.joinToString(""))
                queue.clear()
            }
        }
    }
    if (queue.isNotEmpty()) {
        while (queue.peek() == '0') {
            queue.poll()
        }
        set.add(queue.joinToString(""))
        queue.clear()
    }
    return set.size
}