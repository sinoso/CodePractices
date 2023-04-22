package leetcode.easy

fun main() {
//    println(firstBadVersion(5))
//    println(firstBadVersion(4))
    println(firstBadVersion(2126753390))
//    println(firstBadVersion(0))
}

//2126753390
//1702766719
fun isBadVersion(version: Int) = (version >= 1702766719)
private fun firstBadVersion(n: Int): Int = recursion(0, n.toLong(), n.toLong()).toInt()

fun recursion(min: Long, max: Long, last: Long): Long {
    val half = (min + max) / 2
    val result = isBadVersion(half.toInt())
    val isFinished = (min == max || max < min)
    return when {
        isFinished ->
            if (result) half else last
        result ->
            recursion(min, half - 1, if (half < last) half else last)
        else ->
            recursion(half + 1, max, last)
    }
}
