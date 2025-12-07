package leetcode.easy

import java.util.PriorityQueue

fun main() {

}

private fun maxNumberOfApples(weight: IntArray): Int {
    var sum = 0
    val max = 5000
    var count = 0
    val sorted = weight.sorted()
    for (i in sorted) {
        sum += i
        if (sum > max)
            break
        count++
    }
    return count
}

private fun maxNumberOfApples2(weight: IntArray): Int {
    var sum = 0
    val queue = PriorityQueue<Int>(3) { o1, o2 -> o2 - o1 }
    val max = 5000
    for (i in weight) {
        if (sum + i <= max) {
            sum += i
            queue.offer(i)
        } else if (queue.peek() > i) {
            sum -= queue.poll()
            sum += i
            queue.offer(i)
        }
    }
    return queue.size
}