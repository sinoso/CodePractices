package leetcode.easy

fun main() {


}

private fun divideString(s: String, k: Int, fill: Char): Array<String> {
    val array = s.chunked(k).toTypedArray()
    if (array.last().length < k) {
        array[array.lastIndex] = array[array.lastIndex] + "$fill".repeat(k - array.last().length)
    }
    return array
}