package leetcode.medium

import printResult

fun main() {
    printResult(actual = intToRoman(58), expected = "LVIII")
    printResult(actual = intToRoman(1994), expected = "MCMXCIV")
}

private fun intToRoman(num: Int): String {
    val sb = StringBuilder()
    var left = num
    fun addRoman(num: Int, ten: Char, five: Char, one: Char) {
        when {
            num == 4 -> {
                sb.append(one)
                sb.append(five)
            }

            num == 9 -> {
                sb.append(one)
                sb.append(ten)
            }

            num >= 5 -> {
                sb.append(five)
                repeat(num) {
                    sb.append(one)
                }
            }

            else -> {
                repeat(num) {
                    sb.append(one)
                }
            }
        }
    }
    //1000
    if (left >= 1000) {
        repeat(left / 1000) {
            sb.append("M")
        }
        left %= 1000
    }
    //100
    if (left >= 100) {
        val s = left / 100
        left %= 100
        addRoman(num = s, ten = 'M', five = 'D', one = 'C')
    }

    //10
    if (left >= 10) {
        val s = left / 10
        left %= 10
        addRoman(num = s, ten = 'C', five = 'L', one = 'X')
    }
    //1
    if (left >= 1) {
        addRoman(num = left, ten = 'X', five = 'V', one = 'I')
    }
    return sb.toString()
}