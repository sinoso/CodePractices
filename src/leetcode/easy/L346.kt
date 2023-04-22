package leetcode.easy


fun main() {
//    val class1 = MovingAverage(3)
//    intArrayOf(1, 10, 3, 5).forEach {
//        println(class1.next(it))
//    }
    with(MovingAverage(1)) {
        intArrayOf(4, 0).forEach {
            println(next(it))
        }
    }
}

class MovingAverage(val maxSize: Int) {
    private val queue = ArrayDeque<Int>()
    fun next(`val`: Int): Double {
        queue.add(`val`)
        if(queue.size>maxSize)
            queue.removeFirst()
        return queue.average()
    }
}

//class MovingAverage(val maxSize: Int) {
//    private val list = ArrayList<Double>()
//    fun next(`val`: Int): Double {
//        list.add(`val`.toDouble())
//        return list.takeLast(maxSize).average()
//    }
//}

//class MovingAverage(val maxSize: Int) {
//
//    private val list = ArrayList<Double>()
//
//    fun next(`val`: Int): Double {
//        if (list.size < maxSize)
//            list.add(`val`.toDouble())
//        else {
//            list.add(`val`.toDouble())
//            list.removeAt(0)
//        }
//        return list.average()
//    }
//
//}
