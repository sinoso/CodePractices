package leetcode.easy


fun main() {
//    println(
//        countNegatives(
//            arrayOf(
//                intArrayOf(4, 3, 2, -1),
//                intArrayOf(3, 2, 1, -1),
//                intArrayOf(1, 1, -1, -2),
//                intArrayOf(-1, -1, -2, -3)
//            )
//        )
//    )
    println(countNegatives(arrayOf(intArrayOf(10))))//0
    println(countNegatives(arrayOf(intArrayOf(4, 3, 2, 0))))//0
    println(countNegatives(arrayOf(intArrayOf(4, 3, 2, -1))))//1
    println(countNegatives(arrayOf(intArrayOf(4, 3, -2, -1))))//2
    println(countNegatives(arrayOf(intArrayOf(4, -3, -2, -1))))//3
    println(countNegatives(arrayOf(intArrayOf(-4, -3, -2, -1))))//4
}

private fun countNegatives(grid: Array<IntArray>): Int {
    var answer = 0
    grid.forEach {
        it.forEach {
            if(it<0)
                answer++
        }
    }
    return answer
}


//private fun countNegatives2(grid: Array<IntArray>) = grid.map(::bSearch).sum()
//
//
//fun bSearch(array: IntArray): Int {
//    if (array.size == 1)
//        return if (array[0] > 0) 0 else 1
//    var left = 0
//    var right = array.lastIndex
//
//    while (left != right) {
//        val pivot = (left + right) / 2
//        if (array[pivot] > -1)
//            left = pivot + 1
//        else
//            right = pivot
//    }
//    if (left == 0)
//        return array.size
//    if (left == array.lastIndex)
//        if (array[left] < 0)
//            return 1
//        else
//            return 0
//    return array.size - left
//}
