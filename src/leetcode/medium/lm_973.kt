package leetcode.medium

import java.util.*


fun main() {

}

private fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
    val heap = PriorityQueue<IntArray>(compareByDescending { (x: Int, y: Int) -> x * x + y * y })
    points.forEach {
        if (heap.size < k)
            heap.add(it)
        else {
            if (heap.peek().distance() > it.distance()){
                heap.poll()
                heap.add(it)
            }
        }
    }
    return heap.toTypedArray()
}

private fun IntArray.distance() = this[0] * this[0] + this[1] * this[1]

private fun kClosest2(points: Array<IntArray>, k: Int): Array<IntArray> {
    val heap = PriorityQueue<IntArray>(compareBy { (x: Int, y: Int) -> x * x + y * y })
    points.forEach { heap.add(it) }
    val array = Array(k) { intArrayOf() }
    repeat(k) {
        array[k] = heap.poll()
    }
    return array
}
