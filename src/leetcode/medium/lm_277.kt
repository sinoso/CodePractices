package leetcode.medium

import printResult

fun main() {
    val sol = Sol()
    printResult(sol.findCelebrity(2), -1)
}

private class Sol : Relation() {
    override fun findCelebrity(n: Int): Int {
        var celeb = -1
        for (i in 0 until n) {
            if (isCelebrity(i, n)) {
                if (celeb == -1)
                    celeb = i
                else
                    return -1
            }
        }
        return celeb
    }

    fun isCelebrity(current: Int, size: Int): Boolean {
        var result = true
        var count = 0
        for (i in 0 until size) {
            if (!result)
                break
            if (current == i)
                continue
            result = !knows(current, i)
            if (knows(i, current))
                count++
        }
        if (result)
            result = count == size - 1
        return result
    }

    fun findCelebrity2(n: Int): Int {
        val celebrityAbles = mutableListOf<Int>()
        val array = Array(n) { 0 }
        for (i in 0 until n) {
            var count = 0
            for (j in 0 until n) {
                if (i == j)
                    continue
                if (knows(i, j)) {
                    array[j]++
                    count++
                }
            }
            if (count == 0)
                celebrityAbles.add(i)
        }
        var celebrity = 0
        var checked = false
        for (i in celebrityAbles) {
            if (array[i] == n - 1) {
                if (checked)
                    return -1
                celebrity = i
                checked = true
            }
        }
        if (checked)
            return celebrity
        return -1
    }

    fun knows(a: Int, b: Int) = true
}


open class Relation {
    open fun findCelebrity(n: Int): Int = 0
}
