package leetcode.easy

fun main() {
    println(addDigits(38))
    println(addDigits(10))
//    println(addDigits(0))
}

private fun addDigits(num: Int): Int {
    var sum = num
    var temp = 0
    while (sum >= 10) {
        while (sum >= 10) {
            temp += sum % 10
            sum /= 10
        }
        sum += temp
        temp = 0
    }
    return sum
}
