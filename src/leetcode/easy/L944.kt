package leetcode.easy

fun main() {

}

private fun minDeletionSize(strs: Array<String>): Int {
    var answer = 0
    for (i in strs.first().indices) {
        var last = 'a'
        for (j in strs.indices) {
            if (last > strs[j][i]) {
                answer++
                break
            }
            last = strs[j][i]
        }
    }
    return answer
}