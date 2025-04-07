package leetcode.easy

fun main() {

}

private fun countLargestGroup(n: Int): Int {
    val table = Array<Boolean>(n + 1) { false }
    fun setValues(target: Int) {
        for (i in target..n step target) {
            table[i] = true
        }
    }
    setValues(3)
    setValues(5)
    setValues(7)
    var sum = 0
    for (i in table.indices) {
        if (table[i])
            sum+=i
    }
    return sum
}