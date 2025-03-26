package leetcode.easy

fun main() {

}

private fun lemonadeChange(bills: IntArray): Boolean {
    var p5 = 0
    var p10 = 0

    for (bill in bills) {
        when (bill) {
            5 -> p5++
            10 -> {
                if (p5 == 0) return false

                p5--
                p10++
            }

            20 -> {
                if (p10 == 0) {
                    if (p5 < 3) return false
                    p5 -= 3
                } else {
                    p10--
                    if (p5 < 1) return false
                    p5--
                }
            }
        }
    }
    return true
}