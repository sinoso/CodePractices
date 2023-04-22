package leetcode.easy

fun main() {
    println(numberOfSteps(14))
    println(numberOfSteps(8))
    println(numberOfSteps(123))
}


private fun numberOfSteps(num: Int): Int {
    var tries = 0
    var value = num
    while (value > 0) {
        tries++
        if(value and 1 == 1){
            value-=1
            continue
        }
        value/=2
    }
    return tries
}
