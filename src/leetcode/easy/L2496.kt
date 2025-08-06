package leetcode.easy

fun main() {


}

private fun maximumValue(strs: Array<String>): Int =
    strs.maxOf {
        if (it.all { it.isDigit() })
            it.toInt()
        else
            it.length
    }