package leetcode.easy

fun main() {

}

private fun validateCoupons(code: Array<String>, businessLine: Array<String>, isActive: BooleanArray): List<String> {
    val electronics = mutableListOf<String>()
    val grocery = mutableListOf<String>()
    val pharmacy = mutableListOf<String>()
    val restaurant = mutableListOf<String>()
    val map = HashMap<String, MutableList<String>>().apply {
        put("electronics", electronics)
        put("grocery", grocery)
        put("pharmacy", pharmacy)
        put("restaurant", restaurant)
    }
    for (i in code.indices) {
        if (!isActive[i])
            continue
        if (code[i].isEmpty())
            continue
        val list = map[businessLine[i]] ?: continue
        if (code[i].all { c: Char -> c in 'a'..'z' || c in 'A'..'Z' || c in '0'..'9' || c == '_' }) {
            list.add(code[i])
        }
    }
    return electronics.sorted() + grocery.sorted() + pharmacy.sorted() + restaurant.sorted()
}

private fun validateCoupons2(code: Array<String>, businessLine: Array<String>, isActive: BooleanArray): List<String> {
    val businessLineSet = linkedSetOf("electronics", "grocery", "pharmacy", "restaurant")
    val answerList = mutableListOf<Pair<String, Int>>()
    for (i in code.indices) {
        if (!isActive[i])
            continue
        if (!businessLineSet.contains(businessLine[i]))
            continue
        if (code[i].isEmpty())
            continue
        if (code[i].all { c: Char -> c.isDigit() || c.isLetterOrDigit() || c.isLowerCase() || c == '_' }) {
            answerList.add(code[i] to businessLineSet.indexOf(businessLine[i]))
        }
    }
    return answerList.sortedWith(compareBy<Pair<String, Int>> { it.second }.thenBy { it.first }).map { it.first }
}