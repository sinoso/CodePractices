package leetcode.hard

import java.util.*


fun main() {
    val m = MedianFinder()
    m.addNum(1)
    m.addNum(5)
    m.addNum(2)
    m.addNum(6)
    m.addNum(3)
    m.addNum(4)
    MedianFinder().apply {
        arrayOf(6, 10, 2, 6, 5, 0, 6, 3, 1, 0, 0).forEach(this::addNum)
    }
    MedianFinder().apply {
        arrayOf(-1, -2, -3, -4, -5).forEach(this::addNum)
    }
}

/**
우리는 중앙 값이 필요

priority queue 를 이용 하면 특정 상승 하양 방향의 값만 신경 쓸 수있다.

추가되는 값들을 Ascending으로 정리 했다고 생각 하면,

두개의 priority queue를 이용 front, rear로 취급한다.

즉 front-> max prority, rear -> min prority

각각의 peek를 통하여 중간값 또는 절반위치의 값을 알게 된다.

 */
class MedianFinder {
    private val frontQueue = PriorityQueue<Int>(compareByDescending { it })
    private val rearQueue = PriorityQueue<Int>(compareBy { it })
    private var count = 0

    fun addNum(num: Int) {
        rearQueue.add(num)
        count++
        if (count and 1 == 0) {
            frontQueue.offer(rearQueue.poll())
        }
        if ((frontQueue.peek() ?: 0) > (rearQueue.peek() ?: 0)) {
            frontQueue.offer(rearQueue.poll())
            rearQueue.offer(frontQueue.poll())
        }
    }

    fun findMedian(): Double {
        if (count and 1 == 1) {
            return (rearQueue.peek() ?: 0).toDouble()
        }
        return (frontQueue.peek() + rearQueue.peek()) / 2.0
    }
}

