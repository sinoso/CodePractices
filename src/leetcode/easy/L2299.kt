package leetcode.easy

fun main() {

}

private fun strongPasswordCheckerII(password: String): Boolean {
    if (password.length < 8)
        return false
    var containsLower = false
    var containsUpper = false
    var containsDigit = false
    var containsSpecial = false
    var lastChar = ' '
    for (c in password) {
        if (lastChar == c)
            return false
        lastChar = c
        if (containsLower || c.isLowerCase()) {
            containsLower = true
        }
        if (containsUpper || c.isUpperCase()) {
            containsUpper = true
        }
        if (containsDigit || c.isDigit()) {
            containsDigit = true
        }
        if (containsSpecial || c in "!@#$%^&*()-+") {
            containsSpecial = true
        }
    }
    return containsLower && containsUpper && containsDigit && containsSpecial
}