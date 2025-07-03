package leetcode.easy

fun main() {


}

private fun licenseKeyFormatting(s: String, k: Int): String =
    buildString {
        var count = 0
        for (i in s.indices.reversed()) {
            if (s[i] == '-')
                continue
            append(s[i].uppercaseChar())
            count++
            if (count == k) {
                count = 0
                append('-')
            }
        }
        if (this.isNotBlank() && this.last() == '-')
            this.deleteCharAt(this.lastIndex)
        reverse()
    }