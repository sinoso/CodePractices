package leetcode.easy

fun main() {
    println(numJewelsInStones("aA", "aAAbbbb"))
}

private fun numJewelsInStones(jewels: String, stones: String): Int {
    val hashSet = HashSet<Char>()
    jewels.toCharArray().forEach {
        hashSet.add(it)
    }
    return stones.toCharArray().filter { hashSet.contains(it) }.size
}

private fun numJewelsInStones2(jewels: String, stones: String): Int =
    jewels
        .toCharArray()
        .toHashSet()
        .run {
            stones
                .toCharArray()
                .filter { this.contains(it) }
                .size
        }
