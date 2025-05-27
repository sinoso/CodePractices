package leetcode.easy

fun main() {

}

private fun differenceOfSums(n: Int, m: Int): Int {
    var notDivided = 0
    var divided = 0
    var modM = m
    for (i in 1..n) {
        if (i == modM) {
            divided += modM
            modM += m
            continue
        }
        notDivided += i
    }
    return notDivided - divided
}