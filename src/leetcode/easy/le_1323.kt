package leetcode.easy

fun main() {
    println(maximum69Number(9969))
    println(maximum69Number(9996))
    println(maximum69Number(9999))
    println(maximum69Number(6996))
}


private fun maximum69Number(num: Int): Int {
    val array = num.toString().toCharArray()
    val index = array.indexOfFirst { it == '6' }
    if(index==-1)
        return num
    array[index] = '9'
    return String(array).toInt()
}
