package leetcode.easy

import java.util.LinkedList


fun main() {
//    val class1 = MovingAverage(3)
//    intArrayOf(1, 10, 3, 5).forEach {
//        println(class1.next(it))
//    }
    with(MovingAverage2(2)) {
        intArrayOf(4, 0, 1).forEach {
            println(next(it))
        }
    }
}

class MovingAverage(val maxSize: Int) {
    private val queue = ArrayDeque<Int>()
    fun next(`val`: Int): Double {
        queue.add(`val`)
        if (queue.size > maxSize)
            queue.removeFirst()
        return queue.average()
    }
}

class MovingAverage2(val maxSize: Int) {
    private var count = 0
    private var sum = 0.0
    private val queue = LinkedList<Int>()

    fun next(`val`: Int): Double {
        queue.offer(`val`)
        if (count == maxSize) {
            sum -= queue.pop()
        } else {
            count++
        }
        sum += `val`
        return sum / count
    }
}
