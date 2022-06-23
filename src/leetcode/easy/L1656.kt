package leetcode.easy

fun main() {

}

class OrderedStream(val n: Int) {
    private var p = 0
    private val array = Array<String?>(n) { null }
    fun insert(idKey: Int, value: String): List<String> {
        array[idKey - 1] = value
        val list = mutableListOf<String>()
        while (p < n && array[p] != null) {
            list.add(array[p++]!!)
        }
        return list
    }
}
