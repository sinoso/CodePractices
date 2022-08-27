package leetcode.hard

import printResult


fun main() {
//    printResult(numberToWords(1000),"One Thousand")
//    printResult(numberToWords(123), "One Hundred Twenty Three")
    printResult(numberToWords(1234567), "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven")
}

private val until19 = hashMapOf(
    0 to "",
    1 to " One",
    2 to " Two",
    3 to " Three",
    4 to " Four",
    5 to " Five",
    6 to " Six",
    7 to " Seven",
    8 to " Eight",
    9 to " Nine",
    10 to " Ten",
    11 to " Eleven",
    12 to " Twelve",
    13 to " Thirteen",
    14 to " Fourteen",
    15 to " Fifteen",
    16 to " Sixteen",
    17 to " Seventeen",
    18 to " Eighteen",
    19 to " Nineteen"
)
private val tens = hashMapOf(
    2 to " Twenty",
    3 to " Thirty",
    4 to " Forty",
    5 to " Fifty",
    6 to " Sixty",
    7 to " Seventy",
    8 to " Eighty",
    9 to " Ninety"
)

fun numberToWords(num: Int): String {
    if (num == 0)
        return "Zero"
    val result = StringBuilder()
    var left = num
    val bil = left / 1_000_000_000
    left %= 1_000_000_000
    val mil = left / 1_000_000
    left %= 1_000_000
    if (bil > 0) {
        result.append(numToString(bil))
        result.append(" Billion")
    }
    if (mil > 0) {
        result.append(numToString(mil))
        result.append(" Million")
    }
    if (left > 0) {
        result.append(numToString(left))
    }
    return result.trim().toString()
}

fun numToString(value: Int): StringBuilder {
    val sb = StringBuilder()
    val thousand = value / 1000
    if (thousand != 0) {
        under1000toSb(thousand, sb)
        sb.append(" Thousand")
    }
    under1000toSb(value % 1000, sb)
    return sb
}

fun under1000toSb(value: Int, sb: StringBuilder) {
    val hundred = value / 100
    val under100 = value % 100
    if (hundred != 0) {
        sb.append(until19[hundred])
        sb.append(" Hundred")
    }
    if (under100 != 0) {
        if (under100 < 20) {
            sb.append(until19[under100])
            return
        }
        sb.append(tens[under100 / 10])
        if (under100 % 10 > 0) {
            sb.append(until19[under100 % 10])
        }
    }
}
