package leetcode.easy

fun main() {
    println(maximum69Number(9969))
    println(maximum69Number(9996))
    println(maximum69Number(9999))
    println(maximum69Number(6996))
}


private fun maximum69Number(num: Int): Int {
    val size = Math.log10(num.toDouble()).toInt()
    var divider = Math.pow(10.0, size.toDouble()).toInt()
    var rest = num
    while (rest != 0) {
        val temp: Int = rest / divider
        if (temp == 6)
            break
        rest %= divider
        divider = divider/ 10 
    }
    if (rest == 0)
        return num
    return num + divider * 3
}

private fun maximum69Number2(num: Int): Int {
    val array = num.toString().toCharArray()
    val index = array.indexOfFirst { it == '6' }
    if (index == -1)
        return num
    array[index] = '9'
    return String(array).toInt()
}
