package leetcode.easy

fun main() {

}

private fun relativeSortArray(arr1: IntArray, arr2: IntArray): IntArray {
    val map = HashMap<Int, Int>().apply {
        arr2.withIndex().forEach {
            this[it.value] = it.index
        }
    }
    return arr1.sortedWith(compareBy { map[it]?: (1000+it) }).toIntArray()
}
