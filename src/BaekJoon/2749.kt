package BaekJoon

fun main() {
    val reader = System.`in`.bufferedReader()
    val a: Long = reader.readLine().toLong() % 1_500_000
    var first = 0
    var second = 1
    var temp: Int
    repeat((a - 1).toInt()) {
        temp = (first + second) % 1_000_000
        first = second
        second = temp
    }
    println(second)
}
