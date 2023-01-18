package leetcode.medium

fun main() {
//    println(getIndex(ArrayReader(intArray = IntArray(4) { it })))
    println(getIndex(ArrayReader(intArray = intArrayOf(2,1,1,1))))
    println(getIndex(ArrayReader(intArray = intArrayOf(1,2))))
    println(getIndex(ArrayReader(intArray = intArrayOf(1,1,1,1,1,2))))
    println(getIndex(ArrayReader(intArray = intArrayOf(1,1,1,1,1,2))))

}

class ArrayReader(val intArray: IntArray) {

    fun compareSub(l: Int, r: Int, x: Int, y: Int): Int {
        var left = 0
        for (i in l..r) {
            left += intArray[i]
        }
        var right = 0
        for (i in x..y) {
            right += intArray[i]
        }
        return if (left > right) 1 else if (left == right) 0 else -1
    }

    fun length(): Int = intArray.size
}

fun getIndex(reader: ArrayReader): Int {
    val lastIndex = reader.length() - 1
    var l = 0
    var y = lastIndex
    val diff = (y - l - 1) / 4
    var r = l + diff
    var x = y - diff
    while (l != y) {
        when (reader.compareSub(l, r, x, y)) {
            1 -> {
                y = r
            }

            0 -> {
                l = r + 1
                y = x - 1
            }

            -1 -> {
                l = x
            }
        }
        val diff = (y - l - 1) / 4
        r = l + diff
        x = y - diff
    }
    return l
}
//l     r l r          x  y  x        y
//0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
//        l r x y