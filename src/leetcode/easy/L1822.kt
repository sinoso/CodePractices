package leetcode.easy

fun main() {

}

fun arraySign(nums: IntArray): Int {
    var isNegative = false
    for (i in nums) {
        if (i == 0)
            return 0
        if (i < 0)
            isNegative = !isNegative
    }
    return if (isNegative) -1 else 1
}
