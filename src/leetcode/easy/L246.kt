package leetcode.easy

fun main() {

}

private fun isStrobogrammatic(num: String): Boolean {
    var left = 0
    var right = num.lastIndex
    while (left < right) {
        when (num[left]) {
            '1', '8', '0' -> {
                if (num[right] != num[left])
                    return false
            }
            '6', '9' -> {
                if (num[right] == num[left])
                    return false
            }
            else -> return false
        }
        left++
        right++
    }
    if (left > right)
        return true
    return num[left] != '1' || num[left] != '8' || num[left] != '0'
}
// 1   6  8 9 0


