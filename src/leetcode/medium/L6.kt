package leetcode.medium

fun main() {
    convert("PAYPALISHIRING", 3)
}
//"PAHNAAAAAAAAYAYAYAPSI"
//"PAHNAPLSIIGYIR"

// 23:16 ~ 23:42
private fun convert(s: String, numRows: Int): String {
    if (numRows == 1)
        return s
    val sb = StringBuilder()
    val lastIndex = s.lastIndex
    val range = (numRows - 1) * 2
    for (i in 0..lastIndex step range) {
        sb.append(s[i])
    }
    for (i in 1 until numRows - 1) {
        val diff = range - i * 2
        for (j in i..lastIndex step range) {
            sb.append(s[j])
            val secondIndex = j + diff
            if (secondIndex <= lastIndex)
                sb.append(s[secondIndex])
        }
    }
    for (i in (numRows - 1)..lastIndex step range) {
        sb.append(s[i])
    }
    return sb.toString()
}

// %8 (n-1)*2
//0      0
//1     7
//2   6
//3 5
//4

// %6 (n-1)*2
//0     0    N
//1   5 S  I G
//2 4   H R
//3     I

// % 4   (n-1)*2
//0   0
//1 3
//2

// %2
//A C
//B
