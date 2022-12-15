package leetcode.easy


fun main() {

}

private fun bestHand(ranks: IntArray, suits: CharArray): String {
    if (suits.distinct().size == 1)
        return "Flush"
    val table = IntArray(14)
    for (i in ranks) {
        table[i]++
    }
    val max = table.reduce { acc, i -> acc.coerceAtLeast(i) }
    if (max > 2)
        return "Three of a Kind"
    if (max == 2)
        return "Pair"
    return "High Card"
}

//"Flush": Five cards of the same suit.
//"Three of a Kind": Three cards of the same rank.
//"Pair": Two cards of the same rank.
//"High Card": Any single card.
