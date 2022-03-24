package leetcode.medium

fun main() {

}

fun brokenCalc(startValue: Int, target: Int): Int {
    var left = target
    var count = 0
    while (left > startValue) {
        count++
        if (left and 1 == 1)
            left++
        else
            left /= 2
    }
    return startValue - left + count
}
