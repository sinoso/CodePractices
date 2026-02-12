package leetcode.easy

fun main() {

}

private fun isBalanced(num: String): Boolean {
    var even = 0
    var odd = 0
    for (i in num.indices) {
        val number = num[i] - '0'
        if (i and 1 == 1) {
            odd += number
        }else{
            even += number
        }
    }
    return odd == even
}