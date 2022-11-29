package leetcode.medium

fun main() {

}

class RandomizedSet() {
    val hashSet = HashSet<Int>()

    fun insert(`val`: Int): Boolean = hashSet.add(`val`)

    fun remove(`val`: Int): Boolean = hashSet.remove(`val`)

    fun getRandom(): Int = hashSet.random()

}
