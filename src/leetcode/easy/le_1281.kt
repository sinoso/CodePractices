package leetcode.easy

fun main() {
    println(subtractProductAndSum(234))
}


private fun subtractProductAndSum(n: Int): Int {
    var product = 1
    var sum = 0
    for (c in n.toString()) {
        val currentValue = (c - 48).toInt()

        sum += currentValue
        product *= currentValue
    }
    return product - sum
}

