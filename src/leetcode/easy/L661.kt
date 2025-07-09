package leetcode.easy

fun main() {

}

private fun imageSmoother(img: Array<IntArray>): Array<IntArray> {
    val m = img.size
    val n = img.first().size
    fun smoother(i: Int, j: Int): Int {
        var count = 0
        var sum = 0
        for (k in (i - 1).coerceAtLeast(0)..(i + 1).coerceAtMost(m - 1)) {
            for (l in (j - 1).coerceAtLeast(0)..(j + 1).coerceAtMost(n - 1)) {
                count++
                sum += img[k][l]
            }
        }
        return sum / count
    }

    return Array<IntArray>(m) { i ->
        IntArray(n) { j ->
            smoother(i, j)
        }
    }
}