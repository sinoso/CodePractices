package leetcode.easy


fun main() {
    println(isPalindrome("A man, a plan, a canal: Panama"))//t
    println(isPalindrome("race a car"))//f
    println(isPalindrome(" "))//t
    println(isPalindrome("0P"))//t

}

private fun isPalindrome(s: String): Boolean {
    val list = s.filter(Character::isLetterOrDigit).map(Char::toLowerCase)
    var left = 0
    var right = list.lastIndex
    while (left < right) {
        if (list[left++] != list[right--])
            return false
    }
    return true
}
