package leetcode.easy

fun main() {
    println(romanToInt("III"))
    println(romanToInt("IV"))
    println(romanToInt("IX"))
    println(romanToInt("LVIII"))
    println(romanToInt("MCMXCIV"))
}
private val map = HashMap<Char, Int>().apply {
    put('I', 1)
    put('V', 5)
    put('X', 10)
    put('L', 50)
    put('C', 100)
    put('D', 500)
    put('M', 1000)
}

private fun romanToInt(s: String): Int {
    val array = s.toCharArray()
    var result = 0
    var lastlargest = 0

    for (c in array.reversed()) {
        val value = map[c]!!
        if (value < lastlargest) {
            result -= value
            continue
        }
        if (value > lastlargest)
            lastlargest = value
        result += value
    }
    return result
}
