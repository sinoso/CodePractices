package Programmers

fun main() {
    var result: Int = 0
    var rest: Int = 0
    val array = arrayListOf<Int>()
    var multi = 1
    println(array)
    for (a in  array.reversed()) {
        println(a)
        result += multi * a
        multi *= 3
    }
    println("result$result")
}