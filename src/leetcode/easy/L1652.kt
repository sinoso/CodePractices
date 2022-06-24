package leetcode.easy


fun main() {
    println(decrypt(intArrayOf(2,4,9,3),-2).contentToString())
}

private fun decrypt(code: IntArray, k: Int): IntArray {
    return when {
        k > 0 -> {
            IntArray(code.size) { (it + 1..it + k).fold(0) { acc, i -> code[i % code.size] + acc } }
        }
        k < 0 -> {
            IntArray(code.size) { (it + k until it).fold(0) { acc, i -> code[(i + code.size) % code.size] + acc } }
        }
        else -> {
            IntArray(code.size) { 0 }
        }
    }
}
